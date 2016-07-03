package net.kerupani129.sjgltest.state;

import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

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
        ttf = new SFont(font, true, "メニュー キーで スタート画面 ゲーム に戻る");

	}

	@Override
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {

		// 文字列描画
		ttf.drawString(20, 30, "menumenu メニュー");
		ttf.drawString(300, 200, "Z キーでスタート画面に戻る");
		ttf.drawString(300, 220, "X キーでゲームに戻る");

	}

	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		// 入力キーチェック
		SInput input = container.getInput();

		if ( input.isKeyPressed(SKeyType.CANCEL) ) {
			game.enterState(GameStageState.class, new FadeOutTransition(), new FadeInTransition());
		} else if ( input.isKeyPressed(SKeyType.OK) ) {
			game.enterState(StartMenuState.class, new FadeOutTransition(), new FadeInTransition());
		}

	}

}
