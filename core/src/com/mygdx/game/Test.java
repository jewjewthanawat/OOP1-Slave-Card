package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Card> storageCard;
		storageCard = createCard(52);
		firstValue(storageCard);
		//printValue(storageCard);
		shuffleCard(storageCard);
		//printValue(storageCard);
		sortCard(storageCard);
		printValue(storageCard);
	}
	
	static ArrayList<Card> createCard(int length) {
		ArrayList<Card> card = new ArrayList<Card>();
		for (int i = 0; i < length; i++) {
			card.add(new Card());
		}
		return card;
	}
	
	static void firstValue(ArrayList<Card> card) {
		for (int i = 0; i < card.size(); i++) {
			card.get(i).setValue(10*((i/4)+1)+(i%4)+1);	
		}
	}
	
	static void shuffleCard(ArrayList<Card> card) {
		int random;
		for (int i = 0; i < 2*card.size(); i++) {
			random = MathUtils.random(card.size()-1);
			card.add(card.get(random));
			card.remove(random);
		}
	}
	
	static void printValue(ArrayList<Card> card) {
		for (int i = 0; i < card.size(); i++) {
			System.out.println(card.get(i).getValue());
		}
	}
	
	static void sortCard(ArrayList<Card> card) {
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
	}

}
