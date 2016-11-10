package com.mygdx.game;

import java.util.ArrayList;

public class Bot {
	private int id;
	private ArrayList<Card> card;
	private ArrayList<Card> choosedCard;
	
	Bot(int id) {
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
	
	void sortCard() {
		Card cardAtI = new Card();
		Card cardAtJ = new Card();
		for (int i = 0; i < card.size(); i++) {
			for (int j = i+1; j < card.size(); j++) {
				if (card.get(i).getValue() > card.get(j).getValue()) {
					cardAtI = card.get(i);
					cardAtJ = card.get(j);
					card.remove(j);
					card.remove(i);
					card.add(i,cardAtJ);
					card.add(j,cardAtI);
				}
			}
		}
		for (int i = 0; i < choosedCard.size(); i++) {
			for (int j = i+1; j < choosedCard.size(); j++) {
				if (choosedCard.get(i).getValue() > choosedCard.get(j).getValue()) {
					cardAtI = choosedCard.get(i);
					cardAtJ = choosedCard.get(j);
					choosedCard.remove(j);
					choosedCard.remove(i);
					choosedCard.add(i,cardAtJ);
					choosedCard.add(j,cardAtI);
				}
			}
		}
	}
	
	void play() {
		
	}
}
