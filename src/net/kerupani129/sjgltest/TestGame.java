package net.kerupani129.sjgltest;

import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgltest.state.GameMenuState;
import net.kerupani129.sjgltest.state.GameStageState;
import net.kerupani129.sjgltest.state.StartMenuState;

public class TestGame extends SGame {

    //
    // コンストラクタ
    //
    /**
     * ゲームの初期化
     */
	public TestGame() {
		super("SJGL Test");
        addState(StartMenuState.class);
        addState(GameStageState.class);
        addState(GameMenuState.class);
        this.enterState(StartMenuState.class);
	}

}
