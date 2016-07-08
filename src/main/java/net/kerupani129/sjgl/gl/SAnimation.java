package net.kerupani129.sjgl.gl;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class SAnimation extends Animation {

	//
	// コンストラクタ
	//
	public SAnimation(SpriteSheet ss) {
		super(ss, new int[0], new int[0]);
		super.setAutoUpdate(false);
	}

	//
	// メソッド
	//
	@Override
	@Deprecated
	public void setAutoUpdate(boolean auto) {
		super.setAutoUpdate(auto);
	}

}
