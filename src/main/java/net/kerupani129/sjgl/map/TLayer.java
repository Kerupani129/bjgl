package net.kerupani129.sjgl.map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.Layer;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;

public abstract class TLayer {

	//
	// フィールド
	//
	protected final TMap map;
	protected final Layer layer;

	//
	// コンストラクタ
	//
	public TLayer(TMap map, Layer layer) {
		this.map = map;
		this.layer = layer;
	}

	//
	// メソッド
	//
	public abstract void render(int x, int y, int sx, int sy, int width, int height, boolean lineByLine);
	public void update(SContainer container, SGame game, int delta) throws SlickException {}

}
