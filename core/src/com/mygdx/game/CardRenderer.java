package com.mygdx.game;

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
			textureRegion[1+2] = new TextureRegion(new Texture("200px-Playing_card_diamond_"+ j +".svg.png"));
			textureRegion[1+3] = new TextureRegion(new Texture("200px-Playing_card_heart_"+ j +".svg.png"));
			textureRegion[1+4] = new TextureRegion(new Texture("200px-Playing_card_spade_"+ j +".svg.png"));
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
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		batch.end();
	}
}
