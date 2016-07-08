package net.kerupani129.sjgltest.state;

import java.awt.Font;

import org.newdawn.slick.Color;
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

public class SStateStartMenu extends SState {

	//
	// フィールド
	//
    private SFont ttf;

	//
	// メソッド
	//
    /**
     * 初期化
     */
	@Override
	public void init(SContainer container, SGame game) throws SlickException {

		// フォント
        Font font = new Font("Meiryo", Font.BOLD, 16);
        ttf = new SFont(font, true, "ほげ キーで スタート 終了");

	}

	/**
	 * 描画
	 */
	@Override
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {

		// 楕円描画
		g.fillOval(20, 40, 600, 400);

		// 文字列描画
		ttf.drawString(20, 30, "hogehoge ほげほげ");
		ttf.drawString(300, 200, "Z キーでスタート", Color.black);
		ttf.drawString(300, 220, "X キーで終了", Color.black);

	}

	/**
	 * 移動
	 */
	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		// 入力キーチェック
		SInput input = container.getInput();

		if ( input.isKeyPressed(SKeyType.CANCEL) ) {
			container.exit();
		} else if ( input.isKeyPressed(SKeyType.OK) ) {
			game.enterState(SStateGameStage.class, new FadeOutTransition(), new FadeInTransition());
		}

	}

}
