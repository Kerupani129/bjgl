package net.kerupani129.sjgl.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;

/*
 * TODO: SContainer 以外や SGame 以外から呼ばれたときに対応する
 */
public abstract class SState extends BasicGameState {

	//
	// フィールド
	//
	private int id;
	private boolean idIsInited;

	//
	// コンストラクタ
	//
	/**
	 * 初期化
	 */
	public SState() {
	}

	/**
	 * ID を指定して初期化
	 */
	public SState(int id) {
		initID(id);
	}

	//
	// メソッド
	//
	/**
	 * ID 初期化
	 */
	public final void initID(int id) {
		if ( !this.idIsInited ) {
			this.id = id;
			this.idIsInited = true;
		} else {
			throw new IllegalStateException("初期化済みの SState の ID を初期化しようとしました");
		}
	}

	/**
	 * ID 取得
	 */
	@Override
	public final int getID() {
		if ( !idIsInited ) {
			throw new IllegalStateException("SState の ID が未初期化です");
		}
		return id;
	}

    /**
     * 初期化
     */
	@Override
	public final void init(GameContainer container, StateBasedGame game) throws SlickException {
		System.out.println("SState.init()");
		if ( container instanceof SContainer && game instanceof SGame ) init((SContainer)container, (SGame)game);
		// TODO: ユーザーが拡張できるようにする
	}

	/**
	 * 描画
	 */
	@Override
	public final void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		if ( container instanceof SContainer && game instanceof SGame ) render((SContainer)container, (SGame)game, g);
		// TODO: ユーザーが拡張できるようにする
	}

	/**
	 * 移動
	 */
	@Override
	public final void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if ( container instanceof SContainer && game instanceof SGame ) update((SContainer)container, (SGame)game, delta);
		// TODO: ユーザーが拡張できるようにする
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
