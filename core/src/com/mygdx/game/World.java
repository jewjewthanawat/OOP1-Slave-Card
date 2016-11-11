
package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class World {
	private Player player;
	private Player bot1;
	private Player bot2;
	private Player bot3;
	private int turn;
	private int currentPlayer;
	private ArrayList<Card> field;
	private ArrayList<Card> storageCard;
	long lastActTime;
	
	public World() {
		player = new Player(this, 0);
		bot1 = new Player(this, 1);
		bot2 = new Player(this, 2);
		bot3 = new Player(this, 3);
		field = new ArrayList<Card>();
		newGame();
	}
	
	public void update(float delta) {
		sortAllCard();
		if (currentPlayer == player.getId()) {
			//lastActTime = TimeUtils.nanoTime();
			if (player.isWin()) {
				nextCurrentPlayer();
			} else {
				if (bot1.isWin() && bot2.isWin() && bot3.isWin()) {
					endGame();
				} else {
					if (player.isPass()) {
						nextCurrentPlayer();
					} else {
						if (bot1.isPass() && bot2.isPass() && bot3.isPass()) {
							clearField();
							player.playAsPlayer();
						} else {
							player.playAsPlayer();
						}
					}
				}
			}
		} else if (currentPlayer == bot1.getId()) {
			//lastActTime = TimeUtils.nanoTime();
			if (bot1.isWin()) {
				nextCurrentPlayer();
			} else {
				if (player.isWin() && bot2.isWin() && bot3.isWin()) {
					endGame();
				} else {
					if (bot1.isPass()) {
						nextCurrentPlayer();
					} else {
						if (player.isPass() && bot2.isPass() && bot3.isPass()) {
							clearField();
							bot1.playAsBot();
						} else {
							bot1.playAsBot();
						}
					}
				}
			}
		} else if (currentPlayer == bot2.getId()) {
			//lastActTime = TimeUtils.nanoTime();
			if (bot2.isWin()) {
				nextCurrentPlayer();
			} else {
				if (player.isWin() && bot1.isWin() && bot3.isWin()) {
					endGame();
				} else {
					if (bot2.isPass()) {
						nextCurrentPlayer();
					} else {
						if (player.isPass() && bot1.isPass() && bot3.isPass()) {
							clearField();
							bot2.playAsBot();
						} else {
							bot2.playAsBot();
						}
					}
				}
			}
		} else if (currentPlayer == bot3.getId()) {
			//lastActTime = TimeUtils.nanoTime();
			if (bot3.isWin()) {
				nextCurrentPlayer();
			} else {
				if (player.isWin() && bot1.isWin() && bot2.isWin()) {
					endGame();
				} else {
					if (bot3.isPass()) {
						nextCurrentPlayer();
					} else {
						if (player.isPass() && bot1.isPass() && bot2.isPass()) {
							clearField();
							bot3.playAsBot();
						} else {
							bot3.playAsBot();
						}
					}
				}
			}
		} else {
			if (currentPlayer < 0) {
				currentPlayer += 4;
			} else {
				currentPlayer %= 4;
			}
		}
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
		bot1.showCard();
		bot2.showCard();
		bot3.showCard();
		if (!isDelay(1)) {
			clearField();
			player.getCard().clear();
			bot1.getCard().clear();
			bot2.getCard().clear();
			bot3.getCard().clear();
			storageCard.clear();
			player.reset();
			bot1.reset();
			bot2.reset();
			bot3.reset();
			newGame();
		}
	}
	
	ArrayList<Card> getStorageCard() {
		return storageCard;
	}
	
	Player getPlayer(int id) {
		if (id == 0) {
			return player;
		} else if (id == 1) {
			return bot1;
		} else if (id == 2) {
			return bot2;
		}
		return bot3;
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
		for (int i = 0; i < 2*card.size(); i++) {
			random = MathUtils.random(card.size()-1);
			card.add(card.get(random));
			card.remove(random);
		}
	}
	
	int dealCard(ArrayList<Card> card) {
		int threeClub = 0;
		for (int i =0; i < card.size(); i++) {
			if (i % 4 == 0) {
				if (card.get(i).getValue() == 0) {
					threeClub = 0;
				}
				player.addCard(card.get(i));
			}
			if (i % 4 == 1) {
				if (card.get(i).getValue() == 0) {
					threeClub = 1;
				}
				bot1.addCard(card.get(i));
			}
			if (i % 4 == 2) {
				if (card.get(i).getValue() == 0) {
					threeClub = 2;
				}
				bot2.addCard(card.get(i));
			}
			if (i % 4 == 3) {
				if (card.get(i).getValue() == 0) {
					threeClub = 3;
				}
				bot3.addCard(card.get(i));
			}
		}
		card.clear();
		return threeClub;
	}
	
	void sortAllCard() {
		player.sortCard();
		bot1.sortCard();
		bot2.sortCard();
		bot3.sortCard();
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
		return TimeUtils.nanoTime() - lastActTime <= delay*1000000000;
	}
}
