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
	private static float size = 0.5f;
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
		batch.draw(field, 640*size, 440*size, 0, 0, 320*size, 320*size, 1, 1, 0);
		batch.draw(cardBar, 280*size, 100*size, 0, 0, 1040*size, 100*size, 1, 1, 0);
		batch.draw(choosedCardBar, 640*size, 250*size, 0, 0, 320*size, 100*size, 1, 1, 0);
		batch.draw(botCardBar1, 100*size, 250*size, 0, 0, 100*size, 700*size, 1, 1, 0);
		batch.draw(botChoosedCardBar1, 250*size, 440*size, 0, 0, 100*size, 320*size, 1, 1, 0);
		batch.draw(botCardBar2, 450*size, 1000*size, 0, 0, 700*size, 100*size, 1, 1, 0);
		batch.draw(botChoosedCardBar2, 640*size, 850*size, 0, 0, 320*size, 100*size, 1, 1, 0);
		batch.draw(botCardBar3, 1400*size, 250*size, 0, 0, 100*size, 700*size, 1, 1, 0);
		batch.draw(botChoosedCardBar3, 1250*size, 440*size, 0, 0, 100*size, 320*size, 1, 1, 0);
		batch.draw(clockWise, 100*size, 1000*size, 0, 0, 100*size, 100*size, 1, 1, 0);
		batch.draw(round, 250*size, 1000*size, 0, 0, 100*size, 100*size, 1, 1, 0);
		batch.draw(score, 1400*size, 1000*size, 0, 0, 100*size, 100*size, 1, 1, 0);
		batch.draw(storageCard, 110*size, 100*size, 0, 0, 80*size, 100*size, 1, 1, 0);
		batch.draw(submitButton, 1400*size, 170*size, 0, 0, 100*size, 60*size, 1, 1, 0);
		batch.draw(passButton, 1400*size, 100*size, 0, 0, 100*size, 60*size, 1, 1, 0);
		batch.end();
	}
}
