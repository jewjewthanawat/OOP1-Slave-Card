
package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CardRenderer {
	private SlaveCardGame slaveCardGame;
	private World world;
	private TextureRegion[] textureRegion;

	public CardRenderer(SlaveCardGame slaveCardGame, World world) {
		this.slaveCardGame = slaveCardGame;
		this.world = world;
		textureRegion = new TextureRegion[53];
		textureRegion[0] = new TextureRegion(new Texture("200px-Playing_card_blank.png"));
		for (int i = 0 , j = 3; j <= 10; i += 4 , j++) {
			textureRegion[i+1] = new TextureRegion(new Texture("200px-Playing_card_club_"+ j +".svg.png"));
			textureRegion[i+2] = new TextureRegion(new Texture("200px-Playing_card_diamond_"+ j +".svg.png"));
			textureRegion[i+3] = new TextureRegion(new Texture("200px-Playing_card_heart_"+ j +".svg.png"));
			textureRegion[i+4] = new TextureRegion(new Texture("200px-Playing_card_spade_"+ j +".svg.png"));
		}
		textureRegion[33] = new TextureRegion(new Texture("200px-Playing_card_club_J.svg.png"));
		textureRegion[34] = new TextureRegion(new Texture("200px-Playing_card_diamond_J.svg.png"));
		textureRegion[35] = new TextureRegion(new Texture("200px-Playing_card_heart_J.svg.png"));
		textureRegion[36] = new TextureRegion(new Texture("200px-Playing_card_spade_J.svg.png"));
		textureRegion[37] = new TextureRegion(new Texture("200px-Playing_card_club_Q.svg.png"));
		textureRegion[38] = new TextureRegion(new Texture("200px-Playing_card_diamond_Q.svg.png"));
		textureRegion[39] = new TextureRegion(new Texture("200px-Playing_card_heart_Q.svg.png"));
		textureRegion[40] = new TextureRegion(new Texture("200px-Playing_card_spade_Q.svg.png"));
		textureRegion[41] = new TextureRegion(new Texture("200px-Playing_card_club_K.svg.png"));
		textureRegion[42] = new TextureRegion(new Texture("200px-Playing_card_diamond_K.svg.png"));
		textureRegion[43] = new TextureRegion(new Texture("200px-Playing_card_heart_K.svg.png"));
		textureRegion[44] = new TextureRegion(new Texture("200px-Playing_card_spade_K.svg.png"));
		textureRegion[45] = new TextureRegion(new Texture("200px-Playing_card_club_A.svg.png"));
		textureRegion[46] = new TextureRegion(new Texture("200px-Playing_card_diamond_A.svg.png"));
		textureRegion[47] = new TextureRegion(new Texture("200px-Playing_card_heart_A.svg.png"));
		textureRegion[48] = new TextureRegion(new Texture("200px-Playing_card_spade_A.svg.png"));
		textureRegion[49] = new TextureRegion(new Texture("200px-Playing_card_club_2.svg.png"));
		textureRegion[50] = new TextureRegion(new Texture("200px-Playing_card_diamond_2.svg.png"));
		textureRegion[51] = new TextureRegion(new Texture("200px-Playing_card_heart_2.svg.png"));
		textureRegion[52] = new TextureRegion(new Texture("200px-Playing_card_spade_2.svg.png"));
	}
	
	public void render(float delta) {
		renderPlayerCard(delta);
		renderBotCard(delta);
		renderField(delta);
	}
	
	public void renderPlayerCard(float delta) {
		ArrayList<Card> card = world.getPlayer(0).getCard();
		ArrayList<Card> choosedCard = world.getPlayer(0).getChoosedCard();
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		for (int i = 0; i < card.size(); i++) {
			batch.draw(textureRegion[card.get(i).getValue() + 1], 400-20*card.size()+40*i, 50, 0, 0, 40, 50, 1, 1, 0);
		}
		for (int i = 0; i < choosedCard.size(); i++) {
			batch.draw(textureRegion[choosedCard.get(i).getValue() + 1], 400-20*choosedCard.size()+40*i, 125, 0, 0, 40, 50, 1, 1, 0);			
		}
		batch.end();
	}
	
	public void renderBotCard(float delta) {
		ArrayList<Card> bot1Card = world.getPlayer(1).getCard();
		ArrayList<Card> bot1ChoosedCard = world.getPlayer(1).getChoosedCard();
		ArrayList<Card> bot2Card = world.getPlayer(2).getCard();
		ArrayList<Card> bot2ChoosedCard = world.getPlayer(2).getChoosedCard();
		ArrayList<Card> bot3Card = world.getPlayer(3).getCard();
		ArrayList<Card> bot3ChoosedCard = world.getPlayer(3).getChoosedCard();
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		for (int i = bot1Card.size() - 1; i >= 0; i--) {
			batch.draw(textureRegion[bot1Card.get(i).getValue() + 1], 50, 270+10*bot1Card.size()-20*i, 20, 20, 40, 50, 1, 1, -90);
		}
		for (int i = bot1ChoosedCard.size() - 1; i >= 0; i--) {
			batch.draw(textureRegion[bot1ChoosedCard.get(i).getValue() + 1], 125, 270+10*bot1ChoosedCard.size()-20*i, 20, 20, 40, 50, 1, 1, -90);
		}
		for (int i = bot2Card.size() - 1; i >= 0; i--) {
			batch.draw(textureRegion[bot2Card.get(i).getValue() + 1], 370+10*bot2Card.size()-20*i, 500, 20, 25, 40, 50, 1, 1, 180);
		}
		for (int i = bot2ChoosedCard.size() - 1; i >= 0; i--) {
			batch.draw(textureRegion[bot2ChoosedCard.get(i).getValue() + 1], 370+10*bot2ChoosedCard.size()-20*i, 425, 20, 25, 40, 50, 1, 1, 180);
		}
		for (int i = bot3Card.size() - 1; i >= 0; i--) {
			batch.draw(textureRegion[bot3Card.get(i).getValue() + 1], 700, 300-10*bot3Card.size()+20*i, 30, 20, 40, 50, 1, 1, 90);
		}
		for (int i = bot3ChoosedCard.size() - 1; i >= 0; i--) {
			batch.draw(textureRegion[bot3ChoosedCard.get(i).getValue() + 1], 625, 300-10*bot3ChoosedCard.size()+20*i, 30, 20, 40, 50, 1, 1, 90);
		}
		batch.end();
	}
	
	public void renderField(float delta) {
		ArrayList<Card> field = world.getField();
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		for (int i = 0; i < field.size(); i++) {
			batch.draw(textureRegion[field.get(i).getValue() + 1], 400-20*field.size()+40*i, 275, 0, 0, 40, 50, 1, 1, 0);			
		}
		batch.end();
	}
}
