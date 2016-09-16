package net.kerupani129.sjgl.map.object;

import java.util.Properties;

import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.gl.SAnimation;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.ai.TAI;

public abstract class TEvent extends TObjectTile {

	// コンストラクタ
	public TEvent(TMap map, Properties props) {
		super(map, props);

		addAI(0, new TAIEvent(this));
	}

	// メソッド
	@Override
	protected SAnimation getAnimation() {
		return null;
	}

	public abstract void eventUpdate(SContainer container, SGame game, int delta) throws SlickException;

}

class TAIEvent extends TAI {

	// コンストラクタ
	public TAIEvent(TEvent obj) {
		super(obj);
	}

	// メソッド
	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {
		((TEvent) obj).eventUpdate(container, game, delta);
	}

}
