package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BackgroundRenderer {
	private World world;
	private SlaveCardGame slaveCardGame;
	private TextureRegion field;
	private TextureRegion cardBar;
	private TextureRegion choosedCardBar;
	private TextureRegion botCardBar1;
	private TextureRegion botChoosedCardBar1;
	private TextureRegion botCardBar2;
	private TextureRegion botChoosedCardBar2;
	private TextureRegion botCardBar3;
	private TextureRegion botChoosedCardBar3;
	private TextureRegion clockWise;
	private TextureRegion round;
	private TextureRegion score;
	private TextureRegion storageCard;
	private TextureRegion submitButton;
	private TextureRegion passButton;
	
	public BackgroundRenderer(SlaveCardGame slaveCardGame , World world) {
		this.slaveCardGame = slaveCardGame;
		this.world = world;
		field = new TextureRegion(new Texture("yellow.png"));
		cardBar = new TextureRegion(new Texture("green.png"));
		choosedCardBar = new TextureRegion(new Texture("blue.png"));
		botCardBar1 = new TextureRegion(new Texture("green.png"));
		botChoosedCardBar1 = new TextureRegion(new Texture("blue.png"));
		botCardBar2 = new TextureRegion(new Texture("green.png"));
		botChoosedCardBar2 = new TextureRegion(new Texture("blue.png"));
		botCardBar3 = new TextureRegion(new Texture("green.png"));
		botChoosedCardBar3 = new TextureRegion(new Texture("blue.png"));
		clockWise = new TextureRegion(new Texture("red.png"));
		round = new TextureRegion(new Texture("red.png"));
		score = new TextureRegion(new Texture("red.png"));
		storageCard = new TextureRegion(new Texture("red.png"));
		submitButton = new TextureRegion(new Texture("red.png"));
		passButton = new TextureRegion(new Texture("red.png"));
	}
	
	public void render(float delta) {
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		batch.draw(field, 320, 220, 0, 0, 160, 160, 1, 1, 0);
		batch.draw(cardBar, 140, 50, 0, 0, 520, 50, 1, 1, 0);
		batch.draw(choosedCardBar, 320, 125, 0, 0, 160, 50, 1, 1, 0);
		batch.draw(botCardBar1, 50, 125, 0, 0, 50, 350, 1, 1, 0);
		batch.draw(botChoosedCardBar1, 125, 220, 0, 0, 50, 160, 1, 1, 0);
		batch.draw(botCardBar2, 225, 500, 0, 0, 350, 50, 1, 1, 0);
		batch.draw(botChoosedCardBar2, 320, 425, 0, 0, 160, 50, 1, 1, 0);
		batch.draw(botCardBar3, 700, 125, 0, 0, 50, 350, 1, 1, 0);
		batch.draw(botChoosedCardBar3, 625, 220, 0, 0, 50, 160, 1, 1, 0);
		batch.draw(clockWise, 50, 500, 0, 0, 50, 50, 1, 1, 0);
		batch.draw(round, 125, 500, 0, 0, 50, 50, 1, 1, 0);
		batch.draw(score, 700, 500, 0, 0, 50, 50, 1, 1, 0);
		batch.draw(storageCard, 55, 50, 0, 0, 40, 50, 1, 1, 0);
		batch.draw(submitButton, 700, 87, 0, 0, 50, 30, 1, 1, 0);
		batch.draw(passButton, 700, 50, 0, 0, 50, 30, 1, 1, 0);
		batch.end();
	}
}
