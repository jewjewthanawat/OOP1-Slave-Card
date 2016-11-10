package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	private World world;
	SlaveCardGame slaveCardGame;
	public WorldRenderer(SlaveCardGame slaveCardGame , World world) {
		this.slaveCardGame = slaveCardGame;
		this.world = world;
	}
	
	public void render(float delta) {
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		batch.end();
	}
}
