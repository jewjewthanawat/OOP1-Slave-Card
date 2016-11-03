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
		textureRegion[1] = new TextureRegion(new Texture("200px-Playing_card_club_A.svg.png"));
		textureRegion[2] = new TextureRegion(new Texture("200px-Playing_card_club_2.svg.png"));
		textureRegion[3] = new TextureRegion(new Texture("200px-Playing_card_club_3.svg.png"));
		textureRegion[4] = new TextureRegion(new Texture("200px-Playing_card_club_4.svg.png"));
		textureRegion[5] = new TextureRegion(new Texture("200px-Playing_card_club_5.svg.png"));
		textureRegion[6] = new TextureRegion(new Texture("200px-Playing_card_club_6.svg.png"));
		textureRegion[7] = new TextureRegion(new Texture("200px-Playing_card_club_7.svg.png"));
		textureRegion[8] = new TextureRegion(new Texture("200px-Playing_card_club_8.svg.png"));
		textureRegion[9] = new TextureRegion(new Texture("200px-Playing_card_club_9.svg.png"));
		textureRegion[10] = new TextureRegion(new Texture("200px-Playing_card_club_10.svg.png"));
		textureRegion[11] = new TextureRegion(new Texture("200px-Playing_card_club_J.svg.png"));
		textureRegion[12] = new TextureRegion(new Texture("200px-Playing_card_club_Q.svg.png"));
		textureRegion[13] = new TextureRegion(new Texture("200px-Playing_card_club_K.svg.png"));
		textureRegion[14] = new TextureRegion(new Texture("200px-Playing_card_diamond_A.svg.png"));
		textureRegion[15] = new TextureRegion(new Texture("200px-Playing_card_diamond_2.svg.png"));
		textureRegion[16] = new TextureRegion(new Texture("200px-Playing_card_diamond_3.svg.png"));
		textureRegion[17] = new TextureRegion(new Texture("200px-Playing_card_diamond_4.svg.png"));
		textureRegion[18] = new TextureRegion(new Texture("200px-Playing_card_diamond_5.svg.png"));
		textureRegion[19] = new TextureRegion(new Texture("200px-Playing_card_diamond_6.svg.png"));
		textureRegion[20] = new TextureRegion(new Texture("200px-Playing_card_diamond_7.svg.png"));
		textureRegion[21] = new TextureRegion(new Texture("200px-Playing_card_diamond_8.svg.png"));
		textureRegion[22] = new TextureRegion(new Texture("200px-Playing_card_diamond_9.svg.png"));
		textureRegion[23] = new TextureRegion(new Texture("200px-Playing_card_diamond_10.svg.png"));
		textureRegion[24] = new TextureRegion(new Texture("200px-Playing_card_diamond_J.svg.png"));
		textureRegion[25] = new TextureRegion(new Texture("200px-Playing_card_diamond_Q.svg.png"));
		textureRegion[26] = new TextureRegion(new Texture("200px-Playing_card_diamond_K.svg.png"));
		textureRegion[27] = new TextureRegion(new Texture("200px-Playing_card_heart_A.svg.png"));
		textureRegion[28] = new TextureRegion(new Texture("200px-Playing_card_heart_2.svg.png"));
		textureRegion[29] = new TextureRegion(new Texture("200px-Playing_card_heart_3.svg.png"));
		textureRegion[30] = new TextureRegion(new Texture("200px-Playing_card_heart_4.svg.png"));
		textureRegion[31] = new TextureRegion(new Texture("200px-Playing_card_heart_5.svg.png"));
		textureRegion[32] = new TextureRegion(new Texture("200px-Playing_card_heart_6.svg.png"));
		textureRegion[33] = new TextureRegion(new Texture("200px-Playing_card_heart_7.svg.png"));
		textureRegion[34] = new TextureRegion(new Texture("200px-Playing_card_heart_8.svg.png"));
		textureRegion[35] = new TextureRegion(new Texture("200px-Playing_card_heart_9.svg.png"));
		textureRegion[36] = new TextureRegion(new Texture("200px-Playing_card_heart_10.svg.png"));
		textureRegion[37] = new TextureRegion(new Texture("200px-Playing_card_heart_J.svg.png"));
		textureRegion[38] = new TextureRegion(new Texture("200px-Playing_card_heart_Q.svg.png"));
		textureRegion[39] = new TextureRegion(new Texture("200px-Playing_card_heart_K.svg.png"));
		textureRegion[40] = new TextureRegion(new Texture("200px-Playing_card_spade_A.svg.png"));
		textureRegion[41] = new TextureRegion(new Texture("200px-Playing_card_spade_2.svg.png"));
		textureRegion[42] = new TextureRegion(new Texture("200px-Playing_card_spade_3.svg.png"));
		textureRegion[43] = new TextureRegion(new Texture("200px-Playing_card_spade_4.svg.png"));
		textureRegion[44] = new TextureRegion(new Texture("200px-Playing_card_spade_5.svg.png"));
		textureRegion[45] = new TextureRegion(new Texture("200px-Playing_card_spade_6.svg.png"));
		textureRegion[46] = new TextureRegion(new Texture("200px-Playing_card_spade_7.svg.png"));
		textureRegion[47] = new TextureRegion(new Texture("200px-Playing_card_spade_8.svg.png"));
		textureRegion[48] = new TextureRegion(new Texture("200px-Playing_card_spade_9.svg.png"));
		textureRegion[49] = new TextureRegion(new Texture("200px-Playing_card_spade_10.svg.png"));
		textureRegion[50] = new TextureRegion(new Texture("200px-Playing_card_spade_J.svg.png"));
		textureRegion[51] = new TextureRegion(new Texture("200px-Playing_card_spade_Q.svg.png"));
		textureRegion[52] = new TextureRegion(new Texture("200px-Playing_card_spade_K.svg.png"));
		
	}
	
	public void render(float delta) {
		SpriteBatch batch = slaveCardGame.batch;
		batch.begin();
		batch.end();
	}
}
