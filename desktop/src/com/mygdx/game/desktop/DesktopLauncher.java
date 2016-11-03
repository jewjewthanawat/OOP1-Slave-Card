package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.SlaveCardGame;

public class DesktopLauncher {
	static double size = 0.5;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) (1600*size);
		config.height = (int) (1200*size);
		new LwjglApplication(new SlaveCardGame(), config);
	}
}
