package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class World {
	private Bot bot1;
	private Bot bot2;
	private Bot bot3;
	private Player player;
	private Field field;
	private ArrayList<Card> storageCard;
	
	public World() {
		bot1 = new Bot();
		bot2 = new Bot();
		bot3 = new Bot();
		player = new Player();
		field = new Field();
		storageCard = createCard(52);
		firstValue(storageCard);
		shuffleCard(storageCard);
	}
	
	public void update(float delta) {
		
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
			card.get(i).setValue(10*((i/4)+1)+(i%4)+1);	
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
}
