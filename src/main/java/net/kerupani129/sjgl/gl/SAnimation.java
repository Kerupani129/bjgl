package net.kerupani129.sjgl.gl;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class SAnimation extends Animation {

	//
	// コンストラクタ
	//
	public SAnimation(SpriteSheet tt) {
		super(tt, new int[0], new int[0]);
		super.setAutoUpdate(false);
	}

	//
	// フィールド
	//
	@Override
	@Deprecated
	public void setAutoUpdate(boolean auto) {
		super.setAutoUpdate(auto);
	}

}
