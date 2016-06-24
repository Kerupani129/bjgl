package net.kerupani129.sjgltest.state;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import net.kerupani129.sjgl.SFont;
import net.kerupani129.sjgl.state.SState;

public class StartMenuState extends SState {

	//
	// フィールド
	//
    private SFont ttf;

	//
	// メソッド
	//
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

        Font font = new Font("Meiryo", Font.PLAIN, 16);
        ttf = new SFont(font, true, "hogehoge ほげほげ");

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		ttf.drawString(20, 20);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	}

}
