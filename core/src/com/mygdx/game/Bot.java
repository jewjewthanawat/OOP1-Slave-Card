package com.mygdx.game;

import java.util.ArrayList;

public class Bot {
	private int id;
	private ArrayList<Card> card;
	
	Bot(int id) {
		this.id = id;
	}
	
	ArrayList<Card> getCard() {
		return card;
	}
	
	int getId() {
		return id;
	}

	void addCard(Card insertCard) {
		card.add(insertCard);
	}
	
	void play() {
		
	}
}
