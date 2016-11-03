package com.mygdx.game;

public class Card {
	private int value;
	private boolean open;
	
	public Card(int value, boolean open) {
		this.value = value;
		this.open = open;
	}
	
	public int getValue() {
		return value;
	}

	public boolean isOpen() {
		return open;
	}
	
	public void remove() {
		value = 0;
		open = false;
	}
}
