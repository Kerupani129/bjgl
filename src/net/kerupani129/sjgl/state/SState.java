package net.kerupani129.sjgl.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;

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
			throw new IllegalStateException("SState の ID は初期化済み");
		}
	}

	/**
	 * ID 取得
	 */
	@Override
	public int getID() {
		if ( !idIsInited ) {
			throw new IllegalStateException("SState の ID が未初期化");
		}
		return id;
	}

    /**
     * 初期化
     */
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		if ( container instanceof SContainer && game instanceof SGame ) init((SContainer)container, (SGame)game);
		// throw new IllegalStateException("SState が SContainer 以外から呼ばれた");
	}

	/**
	 * 描画
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		if ( container instanceof SContainer && game instanceof SGame ) render((SContainer)container, (SGame)game, g);
		// throw new IllegalStateException("SState が SContainer 以外から呼ばれた");
	}

	/**
	 * 移動
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if ( container instanceof SContainer && game instanceof SGame ) update((SContainer)container, (SGame)game, delta);
		// throw new IllegalStateException("SState が SContainer 以外から呼ばれた");
	}

    /**
     * 初期化
     */
	public abstract void init(SContainer container, SGame game) throws SlickException;

	/**
	 * 描画
	 */
	public abstract void render(SContainer container, SGame game, Graphics g) throws SlickException;

	/**
	 * 移動
	 */
	public abstract void update(SContainer container, SGame game, int delta) throws SlickException;

}
