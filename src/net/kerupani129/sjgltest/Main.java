package net.kerupani129.sjgltest;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	//
	// フィールド
	//
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final boolean FULLSCREEN = false;

    //
    // メソッド
    //
    /**
     * エントリポイント
     */
	public static void main(String[] args) throws SlickException {

        AppGameContainer app = new AppGameContainer(new TestGame());
        app.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
        app.setTargetFrameRate(60);
        app.setVSync(true);
        // app.setShowFPS(false) ;
        app.start();

	}

}
