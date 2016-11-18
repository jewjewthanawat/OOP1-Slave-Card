
package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class World {
	private Player[] player;
	private int game;
	private int turn;
	private int currentPlayer;
	private int numberOfWinner;
	private ArrayList<Card> field;
	long lastActTime;

	public World() {
		createPlayer();
		game = 0;
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
		if (player[id].isEnd()) {
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
				if (!isDelay(1)) {
					setLastActTime(TimeUtils.nanoTime());
					player[id].playAsBot();
				}
			}
		}
	}

	boolean otherPlayerIsWin(int id) {
		for (int i = 0; i < player.length; i++) {
			if (i != id && !player[i].isEnd()) {
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
		int i , j;
		game++;
		field = createCard(52);
		firstValue(field);
		shuffleCard(field);
		currentPlayer = dealCard(field);
		if (game != 1) {
			for (i = 0; i < player.length; i ++) {
				if (player[i].getRank() == 4) {
					currentPlayer = i;
				}
			}
		}
		sortAllCard();
		numberOfWinner = 0;
		if (game == 1) {
			turn = 1;
			submitFirstCard(currentPlayer);
		} else {
			for (i = 0; i < player.length; i++) {
				if (player[i].getRank() == 1) {
					if (i - currentPlayer == 1 || i - currentPlayer == -3) {
						turn = -1;
					} else  {
						turn = 1;
					}
					player[i].getCard().add(player[currentPlayer].getCard().get(player[currentPlayer].getCard().size() - 1));
					player[i].getCard().add(player[currentPlayer].getCard().get(player[currentPlayer].getCard().size() - 2));
					player[currentPlayer].getCard().remove(player[currentPlayer].getCard().size() - 1);
					player[currentPlayer].getCard().remove(player[currentPlayer].getCard().size() - 1);
					player[currentPlayer].getCard().add(player[i].getCard().get(0));
					player[currentPlayer].getCard().add(player[i].getCard().get(1));
					player[i].getCard().remove(0);
					player[i].getCard().remove(0);
				}
			}
			for (i = 0; i < player.length; i++) {
				if (player[i].getRank() == 2) {
					for (j = 0; j < player.length; j ++) {
						if (player[j].getRank() == 3) {
							player[i].getCard().add(player[j].getCard().get(player[j].getCard().size() - 1));
							player[j].getCard().remove(player[j].getCard().size() - 1);
							player[j].getCard().add(player[i].getCard().get(0));
							player[i].getCard().remove(0);
						}
					}
				}
			}
			sortAllCard();
		}
	}

	void endGame() {
		for (int i = 0; i < player.length; i++) {
			player[i].showCard();
		}
		if (!isDelay(1)) {
			clearField();
			for (int i = 0; i < player.length; i++) {
				player[i].getCard().clear();
				player[i].reset();
			}
			newGame();
		}
	}

	Player getPlayer(int id) {
		return player[id];
	}
	
	int getCurrentPlayer() {
		return currentPlayer;
	}
	
	int getTurn() {
		return turn;
	}
	
	int getNumberOfWinner() {
		return numberOfWinner;
	}
	
	void increaseNumberOfWinner() {
		numberOfWinner++;
	}
	
	String getGame() {
		return "" + game;
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
		if (currentPlayer == player[0].getId()) {
			player[0].chooseCard(0);
		} else if (currentPlayer == player[1].getId()) {
			player[1].chooseCard(0);
		} else if (currentPlayer == player[2].getId()) {
			player[2].chooseCard(0);
		} else if (currentPlayer == player[3].getId()) {
			player[3].chooseCard(0);
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
		field.clear();
		for (int i = 0; i < player[1].getChoosedCard().size(); i++) {
			field.add(player[1].getChoosedCard().get(i));
		}
		player[1].clearChoosedCard();
		for (int i = 0; i < player[2].getChoosedCard().size(); i++) {
			field.add(player[2].getChoosedCard().get(i));
		}
		player[2].clearChoosedCard();
		for (int i = 0; i < player[3].getChoosedCard().size(); i++) {
			field.add(player[3].getChoosedCard().get(i));
		}
		player[3].clearChoosedCard();
		for (int i = 0; i < player[0].getChoosedCard().size(); i++) {
			field.add(player[0].getChoosedCard().get(i));
		}
		player[0].clearChoosedCard();
	}

	void clearField() {
		field.clear();
		player[0].unPass();
		player[1].unPass();
		player[2].unPass();
		player[3].unPass();
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
