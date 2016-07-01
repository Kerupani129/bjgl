package net.kerupani129.sjgltest;

import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgltest.state.GameMenuState;
import net.kerupani129.sjgltest.state.GameStageState;
import net.kerupani129.sjgltest.state.StartMenuState;

public class Main extends SGame {

	//
	// フィールド
	//
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final boolean FULLSCREEN = false;

    //
    // コンストラクタ
    //
    /**
     * ゲームの初期化
     */
	public Main() {

		// タイトル設定
		super("SJGL Test");

		// State 設定
        addState(new StartMenuState());
        addState(new GameStageState());
        addState(new GameMenuState());

        // 開始フェードイン
        enterState(StartMenuState.class, new FadeInTransition(), new EmptyTransition());

	}

    //
    // メソッド
    //
    /**
     * エントリポイント
     */
	public static void main(String[] args) {

		try {
			SContainer app = new SContainer(new Main());
			app.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
			app.setTargetFrameRate(60);
			app.setVSync(true);
			// app.setShowFPS(false) ;
			app.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
