package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.tictactoegame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                
		config.width = tictactoegame.WIDTH;
                config.height = tictactoegame.HEIGHT;
                config.resizable = false;
                new LwjglApplication(new tictactoegame(), config);
                
	}
}
