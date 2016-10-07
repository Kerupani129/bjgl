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

		// TODO: 向きのパース
		// setDirection();
		// getProperty("dir", null);

	}

	// メソッド
	@Override
	protected SAnimation getAnimation() {
		return null;
	}

	public abstract void eventUpdate(SContainer container, SGame game, int delta) throws SlickException;

	/**
	 * プレイヤーが重なった
	 */
	protected boolean overlapedWith(TObject player) {

		return player.getX() == this.getX() && player.getY() == this.getY();

	}

	/**
	 * プレイヤーと向き合った
	 * すなわち、イベントの上下左右のいずれかのマスにプレイヤーがいて、イベントの方を見ている。
	 */
	protected boolean facedWith(TObject player) {

		boolean equalX = false;
		boolean equalY = false;

		switch ( ((TObjectTile) player).getDirection() ) {
		case DOWN:
			equalX = player.getX() == this.getX();
			equalY = player.getY() == this.getY() - this.getHeight();
			break;
		case UP:
			equalX = player.getX() == this.getX();
			equalY = player.getY() == this.getY() + this.getHeight();
			break;
		case LEFT:
			equalX = player.getX() == this.getX() + this.getWidth();
			equalY = player.getY() == this.getY();
			break;
		case RIGHT:
			equalX = player.getX() == this.getX() - this.getWidth();
			equalY = player.getY() == this.getY();
			break;
		}

		return ( equalX && equalY ) ? (true) : (false);

	}

	/**
	 * プレイヤーが進もうとした (当たり判定の有無によらない)
	 */
	@Deprecated
	protected boolean overlappingWith(TObject player) {
		// TODO: 未実装
		return false;
	}

	/**
	 * 調べられた
	 */
	@Deprecated
	protected boolean checkedBy(TObject player) {
		// TODO: 未実装
		return false;
	}

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
