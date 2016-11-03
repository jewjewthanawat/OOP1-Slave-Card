package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundRenderer {
	private World world;
	SlaveCardGame slaveCardGame;
	public BackgroundRenderer(SlaveCardGame slaveCardGame , World world) {
		this.slaveCardGame = slaveCardGame;
		this.world = world;
	}
	
	public void render(float delta) {
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		batch.end();
	}
}
