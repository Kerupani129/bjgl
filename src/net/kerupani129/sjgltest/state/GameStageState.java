package net.kerupani129.sjgltest.state;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.input.SInput;
import net.kerupani129.sjgl.input.SKeyType;
import net.kerupani129.sjgl.state.SState;

public class GameStageState extends SState {

	//
	// メソッド
	//
    /**
     * 初期化
     */
	@Override
	public void init(SContainer container, SGame game) throws SlickException {

	}

	/**
	 * 描画
	 */
	@Override
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {

		// マス目描画
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 15; y++) {
				g.drawRect(x * 32 + 1, y * 32 + 1, 32 - 1 - 1 * 2, 32 - 1 - 1 * 2);
			}
		}

	}

	/**
	 * 移動
	 */
	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		// 入力キーチェック
		SInput input = container.getInput();

		if ( input.isKeyPressed(SKeyType.CANCEL) ) {
			game.enterState(GameMenuState.class);
		} else if ( input.isKeyPressed(SKeyType.OK) ) {
			game.enterState(StartMenuState.class);
		}

	}

}
