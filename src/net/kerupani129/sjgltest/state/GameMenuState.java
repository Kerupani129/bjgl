package net.kerupani129.sjgltest.state;

import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.gl.SFont;
import net.kerupani129.sjgl.input.SInput;
import net.kerupani129.sjgl.input.SKeyType;
import net.kerupani129.sjgl.state.SState;

public class GameMenuState extends SState {

	//
	// フィールド
	//
    private SFont ttf;

	//
	// メソッド
	//
	@Override
	public void init(SContainer container, SGame game) throws SlickException {

		// フォント
        Font font = new Font("Meiryo", Font.BOLD, 16);
        ttf = new SFont(font, true, "menumenu メニュー");

	}

	@Override
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {

		// 文字列描画
		ttf.drawString(20, 30);

	}

	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		// 入力キーチェック
		SInput input = container.getInput();

		if ( input.isKeyPressed(SKeyType.CANCEL) ) {
			game.enterState(GameStageState.class);
		} else if ( input.isKeyPressed(SKeyType.OK) ) {
			game.enterState(GameStageState.class);
		}

	}

}
