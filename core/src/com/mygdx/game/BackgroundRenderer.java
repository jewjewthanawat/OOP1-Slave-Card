package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BackgroundRenderer {
	private SlaveCardGame slaveCardGame;
	private World world;
	private TextureRegion[] turn;
	private TextureRegion round;

	public BackgroundRenderer(SlaveCardGame slaveCardGame, World world) {
		this.slaveCardGame = slaveCardGame;
		this.world = world;
		turn = new TextureRegion[5];
		for (int i = 0; i < turn.length; i++) {
			turn[i] = new TextureRegion(new Texture("player" + i + ".png"));
		}
		round = new TextureRegion(new Texture("red.png"));
	}

	public void render(float delta) {
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		if (world.getCurrentPlayer() >= 0 && world.getCurrentPlayer() < 4) {
			batch.draw(turn[world.getCurrentPlayer()], 0, 0, 0, 0, 800, 600, 1, 1, 0);
		} else {
			batch.draw(turn[4], 0, 0, 0, 0, 800, 600, 1, 1, 0);
		}
		batch.draw(round, 45, 500, 0, 0, 115, 50, 1, 1, 0);
		batch.end();
	}
}
