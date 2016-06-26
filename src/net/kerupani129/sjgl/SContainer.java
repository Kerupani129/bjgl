package net.kerupani129.sjgl;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.input.SInput;

public class SContainer extends AppGameContainer {

	//
	// コンストラクタ
	//
	/**
	 * 初期化
	 */
	public SContainer(SGame game) throws SlickException {
		super(game);
	}

	//
	// メソッド
	//
	/**
	 * GL 初期化
	 */
	@Override
	protected void initGL() {
		input = new SInput(this.height);
		super.initGL();
	}

	/**
	 * SInput を取得
	 */
	@Override
	public SInput getInput() {
		return (SInput) super.getInput();
	}

}
