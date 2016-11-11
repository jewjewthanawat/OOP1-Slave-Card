
package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class World {
	private Player[] player;
	private int turn;
	private int currentPlayer;
	private ArrayList<Card> field;
	private ArrayList<Card> storageCard;
	long lastActTime;

	public World() {
		createPlayer();
		field = new ArrayList<Card>();
		newGame();
	}

	public void update(float delta) {
		sortAllCard();
		if (currentPlayer < 0) {
			currentPlayer += 4;
		} else if (currentPlayer < 4) {
			playerAct(currentPlayer);
		} else {
			currentPlayer %= 4;
		}
	}

	void createPlayer() {
		player = new Player[4];
		for (int i = 0; i < player.length; i++) {
			player[i] = new Player(this, i);
		}
	}

	void playerAct(int id) {
		if (player[id].isWin()) {
			nextCurrentPlayer();
		} else if (otherPlayerIsWin(id)) {
			endGame();
		} else if (player[id].isPass()) {
			nextCurrentPlayer();
		} else {
			if (otherPlayerIsPass(id)) {
				clearField();
			}
			if (id == 0) {
				player[id].playAsPlayer();
			} else {
				player[id].playAsBot();
			}
		}
	}

	boolean otherPlayerIsWin(int id) {
		for (int i = 0; i < player.length; i++) {
			if (i != id && !player[i].isWin()) {
				return false;
			}
		}
		return true;
	}

	boolean otherPlayerIsPass(int id) {
		for (int i = 0; i < player.length; i++) {
			if (i != id && !player[i].isPass()) {
				return false;
			}
		}
		return true;
	}

	void newGame() {
		storageCard = createCard(52);
		firstValue(storageCard);
		shuffleCard(storageCard);
		currentPlayer = dealCard(storageCard);
		sortAllCard();
		turn = 1;
		submitFirstCard(currentPlayer);
	}

	void endGame() {
		for (int i = 0; i < player.length; i++) {
			player[i].showCard();
		}
		if (!isDelay(1)) {
			clearField();
			storageCard.clear();
			for (int i = 0; i < player.length; i++) {
				player[i].getCard().clear();
				player[i].reset();
			}
			newGame();
		}
	}

	ArrayList<Card> getStorageCard() {
		return storageCard;
	}

	Player getPlayer(int id) {
		return player[id];
	}

	ArrayList<Card> getField() {
		return field;
	}

	ArrayList<Card> createCard(int length) {
		ArrayList<Card> card = new ArrayList<Card>();
		for (int i = 0; i < length; i++) {
			card.add(new Card());
		}
		return card;
	}

	void firstValue(ArrayList<Card> card) {
		for (int i = 0; i < card.size(); i++) {
			card.get(i).setValue(i);
		}
	}

	void shuffleCard(ArrayList<Card> card) {
		int random;
		for (int i = 0; i < 2 * card.size(); i++) {
			random = MathUtils.random(card.size() - 1);
			card.add(card.get(random));
			card.remove(random);
		}
	}

	int dealCard(ArrayList<Card> card) {
		int threeClub = 0;
		for (int i = 0; i < card.size(); i++) {
			if (card.get(i).getValue() == 0) {
				threeClub = i % 4;
			}
			player[i % 4].addCard(card.get(i));
		}
		card.clear();
		return threeClub;
	}

	void sortAllCard() {
		for (int i = 0; i < player.length; i++) {
			player[i].sortCard();
		}
	}

	void submitFirstCard(int currentPlayer) {
		if (currentPlayer == player.getId()) {
			player.chooseCard(0);
		} else if (currentPlayer == bot1.getId()) {
			bot1.chooseCard(0);
		} else if (currentPlayer == bot2.getId()) {
			bot2.chooseCard(0);
		} else if (currentPlayer == bot3.getId()) {
			bot3.chooseCard(0);
		} else {
			if (currentPlayer < 0) {
				currentPlayer += 4;
			} else {
				currentPlayer %= 4;
			}
		}
		submitCard();
		lastActTime = TimeUtils.nanoTime();
		currentPlayer += turn;
	}

	void submitCard() {
		for (int i = 0; i < field.size(); i++) {
			storageCard.add(field.get(i));
		}
		field.clear();
		for (int i = 0; i < bot1.getChoosedCard().size(); i++) {
			field.add(bot1.getChoosedCard().get(i));
		}
		bot1.clearChoosedCard();
		for (int i = 0; i < bot2.getChoosedCard().size(); i++) {
			field.add(bot2.getChoosedCard().get(i));
		}
		bot2.clearChoosedCard();
		for (int i = 0; i < bot3.getChoosedCard().size(); i++) {
			field.add(bot3.getChoosedCard().get(i));
		}
		bot3.clearChoosedCard();
		for (int i = 0; i < player.getChoosedCard().size(); i++) {
			field.add(player.getChoosedCard().get(i));
		}
		player.clearChoosedCard();
	}

	void clearField() {
		for (int i = 0; i < field.size(); i++) {
			storageCard.add(field.get(i));
		}
		field.clear();
		player.unPass();
		bot1.unPass();
		bot2.unPass();
		bot3.unPass();
	}

	void setLastActTime(long time) {
		lastActTime = time;
	}

	void nextCurrentPlayer() {
		currentPlayer += turn;
	}

	void switchTurn() {
		turn *= -1;
	}

	boolean isDelay(double delay) {
		return TimeUtils.nanoTime() - lastActTime <= delay * 1000000000;
	}
}
