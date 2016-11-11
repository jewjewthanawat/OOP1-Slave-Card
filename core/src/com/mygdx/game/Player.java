
package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

public class Player {
	private int id;
	private boolean isPass;
	private boolean isEmpty;
	private boolean showCard;
	private World world;
	private ArrayList<Card> card;
	private ArrayList<Card> choosedCard;
	Vector3 position;
	OrthographicCamera camera;

	Player(World world, int id) {
		this.id = id;
		this.world = world;
		isPass = false;
		isEmpty = false;
		showCard = false;
		card = new ArrayList<Card>();
		choosedCard = new ArrayList<Card>();
		position = new Vector3();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
	}

	ArrayList<Card> getCard() {
		return card;
	}

	ArrayList<Card> getChoosedCard() {
		return choosedCard;
	}

	int getId() {
		return id;
	}

	void addCard(Card insertCard) {
		card.add(insertCard);
	}

	void sortCard() {
		Card cardAtI = new Card();
		Card cardAtJ = new Card();
		for (int i = 0; i < card.size(); i++) {
			for (int j = i + 1; j < card.size(); j++) {
				if (card.get(i).getValue() > card.get(j).getValue()) {
					cardAtI = card.get(i);
					cardAtJ = card.get(j);
					card.remove(j);
					card.remove(i);
					card.add(i, cardAtJ);
					card.add(j, cardAtI);
				}
			}
		}
		for (int i = 0; i < choosedCard.size(); i++) {
			for (int j = i + 1; j < choosedCard.size(); j++) {
				if (choosedCard.get(i).getValue() > choosedCard.get(j).getValue()) {
					cardAtI = choosedCard.get(i);
					cardAtJ = choosedCard.get(j);
					choosedCard.remove(j);
					choosedCard.remove(i);
					choosedCard.add(i, cardAtJ);
					choosedCard.add(j, cardAtI);
				}
			}
		}
	}

	void playAsPlayer() {
		if (Gdx.input.isTouched()) {
			position.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(position);
			if (!world.isDelay(0.3) && canChooseCard()) {
				world.setLastActTime(TimeUtils.nanoTime());
				chooseCard(MathUtils.floor((position.x - 400 + 20 * card.size()) / 40));
			}
			if (!world.isDelay(0.3) && canUnchooseCard()) {
				world.setLastActTime(TimeUtils.nanoTime());
				unchooseCard(MathUtils.floor((position.x - 400 + 20 * choosedCard.size()) / 40));
			}
			if (!world.isDelay(0.3) && canSubmitCard()) {
				world.setLastActTime(TimeUtils.nanoTime());
				world.submitCard();
				if (card.size() == 0) {
					win();
					world.switchTurn();
				}
				world.nextCurrentPlayer();
			}
			if (!world.isDelay(0.3) && canPass()) {
				world.setLastActTime(TimeUtils.nanoTime());
				pass();
				world.nextCurrentPlayer();
			}
		}
	}

	void playAsBot() {
		if (world.getField().size() == 0) {
			int random = MathUtils.random(card.size() - 1);
			chooseCard(random);
			world.submitCard();
			if (card.size() == 0) {
				win();
				world.switchTurn();
			}
			world.nextCurrentPlayer();
		} else if (world.getField().size() == 1) {
			int random = MathUtils.random(card.size() - 1);
			if (card.get(card.size() - 1).getValue() < world.getField().get(0).getValue()) {
				pass();
				world.nextCurrentPlayer();
			} else if (card.get(random).getValue() > world.getField().get(0).getValue()) {
				chooseCard(random);
				world.submitCard();
				if (card.size() == 0) {
					win();
					world.switchTurn();
				}
				world.nextCurrentPlayer();
			}
		} else if (world.getField().size() == 2) {
			if (haveTwoCard() && card.get(card.size() - 1).getValue() < world.getField().get(0).getValue()) {
				pass();
				world.nextCurrentPlayer();
			} else if (choosedCard.get(1).getValue() > world.getField().get(1).getValue()) {
				world.submitCard();
				if (card.size() == 0) {
					win();
					world.switchTurn();
				}
				world.nextCurrentPlayer();
			}
			
		} else if (world.getField().size() == 3) {
			if (haveThreeCard() && card.get(card.size() - 1).getValue() < world.getField().get(0).getValue()) {
				pass();
				world.nextCurrentPlayer();
			} else if (choosedCard.get(0).getValue() > world.getField().get(0).getValue()) {
				world.submitCard();
				if (card.size() == 0) {
					win();
					world.switchTurn();
				}
				world.nextCurrentPlayer();
			}
			
		} else {
			if (haveFourCard() && card.get(card.size() - 1).getValue() < world.getField().get(0).getValue()) {
				pass();
				world.nextCurrentPlayer();
			} else if (choosedCard.get(0).getValue() > world.getField().get(0).getValue()) {
				world.submitCard();
				if (card.size() == 0) {
					win();
					world.switchTurn();
				}
				world.nextCurrentPlayer();
			}
		}
	}

	void showCard() {
		showCard = true;
	}

	boolean isShowCard() {
		return showCard;
	}

	void chooseCard(int i) {
		choosedCard.add(card.get(i));
		card.remove(i);
	}

	void unchooseCard(int i) {
		card.add(choosedCard.get(i));
		choosedCard.remove(i);
	}

	void clearChoosedCard() {
		choosedCard.clear();
	}

	boolean isPass() {
		return isPass;
	}

	void pass() {
		isPass = true;
	}

	void unPass() {
		if (!isWin()) {
			isPass = false;
		}
	}

	boolean isWin() {
		return isEmpty;
	}

	void win() {
		isEmpty = true;
		isPass = true;
	}

	void reset() {
		isPass = false;
		isEmpty = false;
		showCard = false;
	}

	boolean canChooseCard() {
		return position.x >= 400 - card.size() * 20 && position.x < 400 + card.size() * 20
				&& position.y >= 50 && position.y < 100 && card.size() > 0
				&& choosedCard.size() < 4;
	}

	boolean canUnchooseCard() {
		return position.x >= 400 - choosedCard.size() * 20
				&& position.x < 400 + choosedCard.size() * 20 && position.y >= 125 && position.y < 175
				&& choosedCard.size() > 0;
	}

	boolean canSubmitCard() {
		if (choosedCard.size() == 0) {
			return false;
		}
		for (int i = 1; i < choosedCard.size(); i++) {
			if (choosedCard.get(i).getValue() / 4 != choosedCard.get(0).getValue() / 4) {
				return false;
			}
		}
		if (world.getField().size() == 0) {
			return position.x >= 700 && position.x < 750 && position.y >= 87 && position.y < 107;
		} else if (world.getField().size() == 1) {
			if (choosedCard.size() == 3) {
				return true;
			}
			return position.x >= 700 && position.x < 750 && position.y >= 87 && position.y < 107 && choosedCard.size() == 1 && choosedCard.get(0).getValue() > world.getField().get(0).getValue();
		} else if (world.getField().size() == 2) {
			if (choosedCard.size() == 4) {
				return true;
			}
			return position.x >= 700 && position.x < 750 && position.y >= 87 && position.y < 107 && choosedCard.size() == 2 && choosedCard.get(1).getValue() > world.getField().get(1).getValue();
		} else if (world.getField().size() == 3) {
			return position.x >= 700 && position.x < 750 && position.y >= 87 && position.y < 107 && choosedCard.size() == 3 && choosedCard.get(0).getValue() > world.getField().get(0).getValue();
		} else if (world.getField().size() == 4) {
			return position.x >= 700 && position.x < 750 && position.y >= 87 && position.y < 107 && choosedCard.size() == 4 && choosedCard.get(0).getValue() > world.getField().get(0).getValue();
		}
		return false;
	}

	boolean canPass() {
		return world.getField().size() != 0 && choosedCard.size() == 0 && position.x >= 700 && position.x < 750 && position.y >= 50 && position.y < 80;
	}
	
	boolean haveTwoCard() {
		for (int i = 0; i < card.size() - 1; i++) {
			chooseCard(i+1);
			chooseCard(i);
			if (choosedCard.get(0).getValue() / 4 == choosedCard.get(1).getValue() / 4) {
				return true;
			} else {
				unchooseCard(1);
				unchooseCard(0);
			}
		}
		return false;
	}
	
	boolean haveThreeCard() {
		for (int i = 0; i < card.size() - 2; i++) {
			chooseCard(i+2);
			chooseCard(i+1);
			chooseCard(i);
			if (choosedCard.get(0).getValue() / 4 == choosedCard.get(1).getValue() / 4 && choosedCard.get(0).getValue() / 4 == choosedCard.get(2).getValue() / 4) {
				return true;
			} else {
				unchooseCard(2);
				unchooseCard(1);
				unchooseCard(0);
			}
		}
		return false;
	}
	
	boolean haveFourCard() {
		for (int i = 0; i < card.size() - 3; i++) {
			chooseCard(i+3);
			chooseCard(i+2);
			chooseCard(i+1);
			chooseCard(i);
			if (choosedCard.get(0).getValue() / 4 == choosedCard.get(1).getValue() / 4 && choosedCard.get(0).getValue() / 4 == choosedCard.get(2).getValue() / 4 && choosedCard.get(0).getValue() / 4 == choosedCard.get(3).getValue() / 4) {
				return true;
			} else {
				unchooseCard(3);
				unchooseCard(2);
				unchooseCard(1);
				unchooseCard(0);
			}
		}
		return false;
	}
}
