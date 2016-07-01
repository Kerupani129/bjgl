package net.kerupani129.sjgl.map.ai;

import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.map.TObject;

public abstract class TObjectAI {

	//
	// フィールド
	//
	public final TObject obj;
	private boolean isStopped = false;

	//
	// コンストラクタ
	//
	public TObjectAI(TObject obj) {
		this.obj = obj;
	}

	//
	// メソッド
	//
	/**
	 * オブジェクト取得
	 */
	protected TObject getObject() {
		return obj;
	}

	/**
	 * AI が止まっているかどうかチェック
	 */
	public boolean isStopped() {
		return isStopped;
	}

	/**
	 * 初期化して実行
	 */
	public void restart() {
		start();
	}

	/**
	 * 実行
	 */
	public void start() {
		isStopped = false;
	}

	/**
	 * 停止
	 */
	public void stop() {
		isStopped = true;
	}

	/**
	 * 移動
	 */
	public abstract void update(SContainer container, SGame game, int delta) throws SlickException;

}
