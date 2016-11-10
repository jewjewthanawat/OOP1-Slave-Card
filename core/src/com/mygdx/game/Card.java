package com.mygdx.game;

public class Card {
	private int value;
	
	public Card() {
		this.value = 0;
	}
	
	public boolean isEmpty() {
		return this.value == 0;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void remove() {
		value = 0;
	}
}
