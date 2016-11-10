package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
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
	Vector3 position;
	OrthographicCamera camera;
	long lastClick;
	
	public World() {
		player = new Player(0);
		bot1 = new Player(1);
		bot2 = new Player(2);
		bot3 = new Player(3);
		field = new ArrayList<Card>();
		position = new Vector3();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
		storageCard = createCard(52);
		firstValue(storageCard);
		shuffleCard(storageCard);
		currentPlayer = dealCard(storageCard);
		sortAllCard();
		turn = 1;
		submitFirstCard(currentPlayer);
	}
	
	public void update(float delta) {
		sortAllCard();
		if (currentPlayer == player.getId()) {
			if (player.isPass() || player.isWin()) {
				currentPlayer += turn;
			} else {
				if (bot1.isPass() && bot2.isPass() && bot3.isPass()) {
					clearField();
					if (Gdx.input.isTouched()) {
						position.set(Gdx.input.getX(), Gdx.input.getY(), 0);
						camera.unproject(position);
						if (!isDelay() && canChooseCard()) {
							lastClick = TimeUtils.nanoTime();
							player.chooseCard(MathUtils.floor((position.x - 400 + 20*player.getCard().size())/40));
						}
						if (!isDelay() && canUnchooseCard()) {
							lastClick = TimeUtils.nanoTime();
							player.unchooseCard(MathUtils.floor((position.x - 400 + 20*player.getChoosedCard().size())/40));
						}
						if (!isDelay() && canSubmitCard()) {
							lastClick = TimeUtils.nanoTime();
							submitCard();
							if (player.getCard().size() == 0) {
								player.win();
								turn *= -1;
							}
							currentPlayer += turn;
						}
					}
				} else {
					if (Gdx.input.isTouched()) {
						position.set(Gdx.input.getX(), Gdx.input.getY(), 0);
						camera.unproject(position);
						if (!isDelay() && canChooseCard()) {
							lastClick = TimeUtils.nanoTime();
							player.chooseCard(MathUtils.floor((position.x - 400 + 20*player.getCard().size())/40));
						}
						if (!isDelay() && canUnchooseCard()) {
							lastClick = TimeUtils.nanoTime();
							player.unchooseCard(MathUtils.floor((position.x - 400 + 20*player.getChoosedCard().size())/40));
						}
						if (!isDelay() && canSubmitCard()) {
							lastClick = TimeUtils.nanoTime();
							submitCard();
							if (player.getCard().size() == 0) {
								player.win();
								turn *= -1;
							}
							currentPlayer += turn;
						}
						if (!isDelay() && canPass()) {
							lastClick = TimeUtils.nanoTime();
							player.pass();
							currentPlayer += turn;
						}
					}
				}		
			}
		} else if (currentPlayer == bot1.getId()) {
			if (bot1.isPass() || bot1.isWin()) {
				currentPlayer += turn;
			} else {
				if (player.isPass() && bot2.isPass() && bot3.isPass()) {
					clearField();
					int random = MathUtils.random(bot1.getCard().size() - 1);
					bot1.chooseCard(random);
					submitCard();
					if (bot1.getCard().size() == 0) {
						bot1.win();
						turn *= -1;
					}
					currentPlayer += turn;
				} else {
					if (field.size() == 0) {
						int random = MathUtils.random(bot1.getCard().size() - 1);
						bot1.chooseCard(random);
						submitCard();
						if (bot1.getCard().size() == 0) {
							bot1.win();
							turn *= -1;
						}
						currentPlayer += turn;
					} else {
						int random = MathUtils.random(bot1.getCard().size() - 1);
						if (bot1.getCard().get(bot1.getCard().size() - 1).getValue() < field.get(field.size() - 1).getValue()) {
							bot1.pass();
							currentPlayer += turn;
						} else if (bot1.getCard().get(random).getValue() > field.get(0).getValue()) {
							bot1.chooseCard(random);
							submitCard();
							if (bot1.getCard().size() == 0) {
								bot1.win();
								turn *= -1;
							}
							currentPlayer += turn;
						}
					}
				}		
			}
		} else if (currentPlayer == bot2.getId()) {
			if (bot2.isPass() || bot2.isWin()) {
				currentPlayer += turn;
			} else {
				if (player.isPass() && bot1.isPass() && bot3.isPass()) {
					clearField();
					int random = MathUtils.random(bot2.getCard().size() - 1);
					bot2.chooseCard(random);
					submitCard();
					if (bot2.getCard().size() == 0) {
						bot2.win();
						turn *= -1;
					}
					currentPlayer += turn;
				} else {
					if (field.size() == 0) {
						int random = MathUtils.random(bot2.getCard().size() - 1);
						bot2.chooseCard(random);
						submitCard();
						if (bot2.getCard().size() == 0) {
							bot2.win();
							turn *= -1;
						}
						currentPlayer += turn;
					} else {
						int random = MathUtils.random(bot2.getCard().size() - 1);
						if (bot2.getCard().get(bot2.getCard().size() - 1).getValue() < field.get(field.size() - 1).getValue()) {
							bot2.pass();
							currentPlayer += turn;
						} else if (bot2.getCard().get(random).getValue() > field.get(0).getValue()) {
							bot2.chooseCard(random);
							submitCard();
							if (bot2.getCard().size() == 0) {
								bot2.win();
								turn *= -1;
							}
							currentPlayer += turn;
						}
					}
				}		
			}
		} else if (currentPlayer == bot3.getId()) {
			if (bot3.isPass() || bot3.isWin()) {
				currentPlayer += turn;
			} else {
				if (player.isPass() && bot1.isPass() && bot2.isPass()) {
					clearField();
					int random = MathUtils.random(bot3.getCard().size() - 1);
					bot3.chooseCard(random);
					submitCard();
					if (bot3.getCard().size() == 0) {
						bot3.win();
						turn *= -1;
					}
					currentPlayer += turn;
				} else {
					if (field.size() == 0) {
						int random = MathUtils.random(bot3.getCard().size() - 1);
						bot3.chooseCard(random);
						submitCard();
						if (bot3.getCard().size() == 0) {
							bot3.win();
							turn *= -1;
						}
						currentPlayer += turn;
					} else {
						int random = MathUtils.random(bot3.getCard().size() - 1);
						if (bot3.getCard().get(bot3.getCard().size() - 1).getValue() < field.get(field.size() - 1).getValue()) {
							bot3.pass();
							currentPlayer += turn;
						} else if (bot3.getCard().get(random).getValue() > field.get(0).getValue()) {
							bot3.chooseCard(random);
							submitCard();
							if (bot3.getCard().size() == 0) {
								bot3.win();
								turn *= -1;
							}
							currentPlayer += turn;
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
			currentPlayer %= 4;
		}
		submitCard();
		lastClick = TimeUtils.nanoTime();
		currentPlayer += turn;
	}
	
	boolean isDelay() {
		return TimeUtils.nanoTime() - lastClick <= 300000000;
	}
	
	boolean canChooseCard() {
		return position.x >= 400 - player.getCard().size()*20 && position.x < 400 + player.getCard().size()*20 && position.y >= 50 && position.y < 100 && player.getCard().size() > 0 && player.getChoosedCard().size() < 4;
	}
	
	boolean canUnchooseCard() {
		return position.x >= 400 - player.getChoosedCard().size()*20 && position.x < 400 + player.getChoosedCard().size()*20 && position.y >= 125 && position.y < 175 && player.getChoosedCard().size() > 0;
	}
	
	boolean canSubmitCard() {
		if (player.getChoosedCard().size() == 0) {
			return false;
		}
		int value = player.getChoosedCard().get(0).getValue()/4;
		for (int i = 1; i < player.getChoosedCard().size(); i++) {
			if (player.getChoosedCard().get(i).getValue()/4 != value) {
				return false;
			}
		}
		if (field.size() == 0) {
			return position.x >= 700 && position.x < 750 && position.y >= 87 && position.y < 107;
		}
		return position.x >= 700 && position.x < 750 && position.y >= 87 && position.y < 107 && player.getChoosedCard().get(0).getValue() > field.get(0).getValue();
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
	
	boolean canPass() {
		return position.x >= 700 && position.x < 750 && position.y >= 50 && position.y < 80 && player.getChoosedCard().size() == 0;
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
}
