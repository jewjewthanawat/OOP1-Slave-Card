package com.mygdx.game;

import java.util.ArrayList;

public class Player {
	private int id;
	private ArrayList<Card> card;
	private ArrayList<Card> choosedCard;
	
	Player(int id) {
		this.id = id;
		card = new ArrayList<Card>();
		choosedCard = new ArrayList<Card>();
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
	
	void play() {
		
	}
}
