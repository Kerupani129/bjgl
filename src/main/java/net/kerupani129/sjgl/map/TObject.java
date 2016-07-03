package net.kerupani129.sjgl.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.gl.SAnimation;
import net.kerupani129.sjgl.map.ai.TObjectAI;

public abstract class TObject {

	//
	// フィールド
	//
	public final TMap map;

	private float x = 0, y = 0;
	private float width = 0, height = 0;
	private Map<Class<? extends TObjectAI>, TObjectAI> aiMap = new HashMap<Class<? extends TObjectAI>, TObjectAI>();
	private Map<Integer, TObjectAI> aiSortedMap = new TreeMap<Integer, TObjectAI>();

	//
	// コンストラクタ
	//
	public TObject(TMap map) {
		this.map = map;
	}

	//
	// メソッド
	//
	/**
	 * AI 追加
	 */
	// TODO: priority の重複を許す
	public void addAI(int priority, TObjectAI ai) {
		aiMap.put(ai.getClass(), ai);
		aiSortedMap.put(priority, ai);
	}

	/**
	 * AI 取得
	 * AI が見つからなければ null を返す
	 */
	public TObjectAI getAI(Class<? extends TObjectAI> oclass) {
		return aiMap.get(oclass);
	}

	/**
	 * 移動
	 */
	public void translate(float x, float y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * 位置設定
	 */
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 大きさ設定
	 */
	public void setSize(float width, float height) {
		this.width  = width;
		this.height = height;
	}

	/**
	 * 位置 X 取得
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * 位置 Y 取得
	 */
	public float getY() {
		return this.y;
	}

	/**
	 * 幅取得
	 */
	public float getWidth() {
		return this.width;
	}

	/**
	 * 高さ取得
	 */
	public float getHeight() {
		return this.height;
	}

	/**
	 * アニメーションの取得
	 */
	protected abstract SAnimation getAnimation();

    /**
     * 描画
     */
	public final void render(SContainer container, SGame game, Graphics g) throws SlickException {
		getAnimation().draw(x, y);
	}

	/**
	 * 移動
	 */
	public final void update(SContainer container, SGame game, int delta) throws SlickException {
		getAnimation().update(delta);

		Log.debug(" TObject: ■AI 開始");
		for (Map.Entry<Integer, TObjectAI> entry : aiSortedMap.entrySet()) {
			TObjectAI ai = entry.getValue();
			Log.debug(" TObject: " + entry.getKey() + " " + ai.getClass().getSimpleName());
			if ( !ai.isStopped() ) ai.update(container, game, delta);
		}
		Log.debug(" TObject: ■AI 終了");
	}

}
