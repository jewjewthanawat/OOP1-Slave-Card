package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WorldRenderer {
	private World world;
	SlaveCardGame slaveCardGame;
	private BitmapFont font;
	private TextureRegion clockWise;
	private TextureRegion counterClockWise;
	private TextureRegion submitButton;
	private TextureRegion passButton;
	private TextureRegion statusPass;
	private TextureRegion statusEnd;

	public WorldRenderer(SlaveCardGame slaveCardGame, World world) {
		this.slaveCardGame = slaveCardGame;
		this.world = world;
		font = new BitmapFont();
		clockWise = new TextureRegion(new Texture("turnleft.png"));
		counterClockWise = new TextureRegion(new Texture("turnright.png"));
		submitButton = new TextureRegion(new Texture("SUBMIT.png"));
		passButton = new TextureRegion(new Texture("PASS.png"));
		statusPass = new TextureRegion(new Texture("pass_state.png"));
		statusEnd = new TextureRegion(new Texture("END.png"));
	}

	public void render(float delta) {
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		font.draw(batch, "Game Round : " + world.getGame(), 50, 530);
		if (world.getTurn() == 1) {
			batch.draw(clockWise, 700, 500, 0, 0, 50, 50, 1, 1, 0);
		} else {
			batch.draw(counterClockWise, 700, 500, 0, 0, 50, 50, 1, 1, 0);
		}
		if (world.getCurrentPlayer() == 0) {
			if (world.getPlayer(0).checkCanPass()) {
				batch.draw(passButton, 700, 50, 0, 0, 50, 50, 1, 1, 0);
			}
			if (world.getPlayer(0).checkCanSubmitCard()) {
				batch.draw(submitButton, 700, 50, 0, 0, 50, 50, 1, 1, 0);
			}
		}
		if (world.getPlayer(0).isPass()) {
			batch.draw(statusPass, 350, 125, 0, 0, 100, 50, 1, 1, 0);
		}
		if (world.getPlayer(0).isEnd()) {
			batch.draw(statusEnd, 350, 50, 0, 0, 100, 50, 1, 1, 0);
		}
		if (world.getPlayer(0).getRank() == 1) {
			font.draw(batch, "K", 395, 35);
		}
		if (world.getPlayer(0).getRank() == 2) {
			font.draw(batch, "Q", 395, 35);
		}
		if (world.getPlayer(0).getRank() == 3) {
			font.draw(batch, "J", 395, 35);
		}
		if (world.getPlayer(0).getRank() == 4) {
			font.draw(batch, "S", 395, 35);
		}
		if (world.getPlayer(1).isPass()) {
			batch.draw(statusPass, 100, 275, 50, 25, 100, 50, 1, 1, -90);
		}
		if (world.getPlayer(1).isEnd()) {
			batch.draw(statusEnd, 25, 275, 50, 25, 100, 50, 1, 1, -90);
		}
		if (world.getPlayer(1).getRank() == 1) {
			font.draw(batch, "K", 20, 315);
		}
		if (world.getPlayer(1).getRank() == 2) {
			font.draw(batch, "Q", 20, 315);
		}
		if (world.getPlayer(1).getRank() == 3) {
			font.draw(batch, "J", 20, 315);
		}
		if (world.getPlayer(1).getRank() == 4) {
			font.draw(batch, "S", 20, 315);
		}
		if (world.getPlayer(2).isPass()) {
			batch.draw(statusPass, 350, 425, 50, 25, 100, 50, 1, 1, 180);
		}
		if (world.getPlayer(2).isEnd()) {
			batch.draw(statusEnd, 350, 500, 50, 25, 100, 50, 1, 1, 180);
		}
		if (world.getPlayer(2).getRank() == 1) {
			font.draw(batch, "K", 395, 580);
		}
		if (world.getPlayer(2).getRank() == 2) {
			font.draw(batch, "Q", 395, 580);
		}
		if (world.getPlayer(2).getRank() == 3) {
			font.draw(batch, "J", 395, 580);
		}
		if (world.getPlayer(2).getRank() == 4) {
			font.draw(batch, "S", 395, 580);
		}
		if (world.getPlayer(3).isPass()) {
			batch.draw(statusPass, 600, 275, 50, 25, 100, 50, 1, 1, 90);
		}
		if (world.getPlayer(3).isEnd()) {
			batch.draw(statusEnd, 675, 275, 50, 25, 100, 50, 1, 1, 90);
		}
		if (world.getPlayer(3).getRank() == 1) {
			font.draw(batch, "K", 770, 315);
		}
		if (world.getPlayer(3).getRank() == 2) {
			font.draw(batch, "Q", 770, 315);
		}
		if (world.getPlayer(3).getRank() == 3) {
			font.draw(batch, "J", 770, 315);
		}
		if (world.getPlayer(3).getRank() == 4) {
			font.draw(batch, "S", 770, 315);
		}
		batch.end();
	}
}
