package com.mygdx.game;

public class World {
	private Bot bot1;
	private Bot bot2;
	private Bot bot3;
	private Player player;
	private Field field;
	private Card[] storageCard;
	
	public World() {
		bot1 = new Bot();
		bot2 = new Bot();
		bot3 = new Bot();
		player = new Player();
		field = new Field();
		storageCard = new Card[52];
		createCard(storageCard);
		shuffleCard(storageCard);
	}
	
	public void update(float delta) {
		
	}
	
	void createCard(Card[] card) {
		for (int i = 0; i < 52; i++) {
			card[i] = new Card(10*((i/4)+1)+(i%4)+1, false);
		}
	}
	
	void shuffleCard(Card[] card) {
		
	}
}
