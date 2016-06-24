package net.kerupani129.sjgl.state;

import org.newdawn.slick.state.BasicGameState;

public abstract class SState extends BasicGameState {

	//
	// フィールド
	//
	private int id;
	private boolean idIsInited;

	//
	// メソッド
	//
	/**
	 * ID 初期化
	 */
	public void initID(int id) {
		if ( !this.idIsInited ) {
			this.id = id;
			this.idIsInited = true;
		} else {
			throw new IllegalStateException("State の ID は初期化済み");
		}
	}

	/**
	 * ID 取得
	 */
	@Override
	public int getID() {
		if ( !idIsInited ) {
			throw new IllegalStateException("State の ID が未初期化");
		}
		return id;
	}
}
