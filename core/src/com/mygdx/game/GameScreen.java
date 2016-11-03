package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
	private World world;
	private WorldRenderer worldRenderer;
	private BackgroundRenderer backgroundRenderer;
	public GameScreen (SlaveCardGame slaveCardGame) {
		this.world = new World();
		this.worldRenderer = new WorldRenderer(slaveCardGame,world);
		this.backgroundRenderer = new BackgroundRenderer(slaveCardGame,world);
	}
	
	@Override
	public void render (float delta) {
		world.update(delta);
		 
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        backgroundRenderer.render(delta);
        worldRenderer.render(delta);
	}
}
