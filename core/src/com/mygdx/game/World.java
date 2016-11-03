package com.mygdx.game;

public class World {
	private Bot bot1;
	private Bot bot2;
	private Bot bot3;
	private Card[] card;
	
	public World() {
		bot1 = new Bot();
		bot2 = new Bot();
		bot3 = new Bot();
		card = new Card[52];
		
	}
	
	public void update(float delta) {
		
	}
}
