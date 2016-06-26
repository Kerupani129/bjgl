package net.kerupani129.sjgltest;

import org.newdawn.slick.state.transition.CombinedTransition;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;

import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.state.transition.WaitTransition;
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

		// タイトル設定
		super("SJGL Test");

		// State 設定
        addState(new StartMenuState());
        addState(new GameStageState());
        addState(new GameMenuState());

        // 開始フェードイン
        CombinedTransition ct = new CombinedTransition();
        ct.addTransition(new WaitTransition(2000));
        ct.addTransition(new FadeInTransition());

        enterState(StartMenuState.class, new EmptyTransition(), ct);

	}

}
