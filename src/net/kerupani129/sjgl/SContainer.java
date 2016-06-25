package net.kerupani129.sjgl;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.input.SInput;

public class SContainer extends AppGameContainer {

	//
	// フィールド
	//
	protected SInput sInput;

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

		sInput = new SInput(this.height);
		input = sInput;

		if ( game instanceof SGame ) ((SGame)game).initInput(sInput);

		super.initGL();

	}

	/**
	 * SInput を取得
	 */
	@Override
	public SInput getInput() {
		return this.sInput;
	}

}
