package net.kerupani129.sjgl.map.object;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.gl.SAnimation;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.ai.TAI;

public abstract class TObject {

	//
	// フィールド
	//
	public final TMap map;

	private float x = 0, y = 0;
	private float width = 0, height = 0;

	private Map<Class<? extends TAI>, TAI> aiMap = new HashMap<Class<? extends TAI>, TAI>();
	private Map<Integer, TAI> aiSortedMap = new TreeMap<Integer, TAI>();

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
	public void addAI(int priority, TAI ai) {
		aiMap.put(ai.getClass(), ai);
		aiSortedMap.put(priority, ai);
	}

	/**
	 * AI 取得
	 * AI が見つからなければ null を返す
	 */
	public TAI getAI(Class<? extends TAI> oclass) {
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
	public final void render() {

		SAnimation anime = getAnimation();
		if ( anime != null && anime.getFrameCount() > 0 ) {
			Image frame = anime.getCurrentFrame();
			anime.draw(x, y + width - frame.getHeight());
		}

	}

	/**
	 * 移動
	 */
	public final void update(SContainer container, SGame game, int delta) throws SlickException {

		SAnimation anime = getAnimation();
		if ( anime != null && anime.getFrameCount() > 0 ) {
			anime.update(delta);
		}

		// Log.debug(" TObject: ■AI 開始");
		for (Map.Entry<Integer, TAI> entry : aiSortedMap.entrySet()) {
			TAI ai = entry.getValue();
			// Log.debug(" TObject: " + entry.getKey() + " " + ai.getClass().getSimpleName());
			if ( !ai.isStopped() ) ai.update(container, game, delta);
		}
		// Log.debug(" TObject: ■AI 終了");
	}

}
