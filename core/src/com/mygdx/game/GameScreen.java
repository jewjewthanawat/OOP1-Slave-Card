package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private SlaveCardGame slaveCardGame;
	private Texture testImg;
	
	public GameScreen (SlaveCardGame slaveCardGame) {
		this.slaveCardGame = slaveCardGame;
		testImg = new Texture("8156.png");
	}
	
	@Override
	public void render (float delta) {
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		batch.draw(testImg, 100, 100);
		batch.end();
	}
}
