package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class World {
	private Bot bot1;
	private Bot bot2;
	private Bot bot3;
	private Player player;
	private int turn;
	private int currentPlayer;
	private Field field;
	private ArrayList<Card> storageCard;
	
	public World() {
		bot1 = new Bot(1);
		bot2 = new Bot(2);
		bot3 = new Bot(3);
		player = new Player(0);
		field = new Field();
		storageCard = createCard(52);
		firstValue(storageCard);
		shuffleCard(storageCard);
		currentPlayer = dealCard(storageCard);
		turn = 1;
	}
	
	public void update(float delta) {
		if (currentPlayer == player.getId()) {
			player.play();
			currentPlayer = (currentPlayer + turn) % 4;
		} else if (currentPlayer == bot1.getId()) {
			bot1.play();
			currentPlayer = (currentPlayer + turn) % 4;
		} else if (currentPlayer == bot2.getId()) {
			bot2.play();
			currentPlayer = (currentPlayer + turn) % 4;
		} else if (currentPlayer == bot3.getId()) {
			bot3.play();
			currentPlayer = (currentPlayer + turn) % 4;
		} else {
			currentPlayer %= 4;
		}
	}
	
	ArrayList<Card> getStorageCard() {
		return storageCard;
	}
	
	Bot getBot(int id) {
		if (id == 1) {
			return bot1;
		} else if (id == 2) {
			return bot2;
		}
		return bot3;
	}
	
	Player getPlayer() {
		return player;
	}
	
	Field getField() {
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
}
