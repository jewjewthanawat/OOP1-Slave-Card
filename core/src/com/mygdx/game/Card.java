package com.mygdx.game;

public class Card {
	private int value;
	private boolean open;
	
	public Card() {
		this.value = 0;
		this.open = false;
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
	
	public void open() {
		this.open = true;
	}
	
	public void close() {
		this.open = false;
	}

	public boolean isOpen() {
		return open;
	}
	
	public void remove() {
		value = 0;
		open = false;
	}
}
