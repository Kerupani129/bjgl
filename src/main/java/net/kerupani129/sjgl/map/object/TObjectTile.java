package net.kerupani129.sjgl.map.object;

import net.kerupani129.sjgl.map.TMap;

public abstract class TObjectTile extends TObject {

	//
	// フィールド
	//
	private TDirection direction = TDirection.DOWN;
	private boolean isTranslating = false;

	//
	// コンストラクタ
	//
	public TObjectTile(TMap map) {
		super(map);
		setSize(map.getTileWidth(), map.getTileHeight());
	}

	//
	// メソッド
	//
	public void setDirection(TDirection direction) {
		this.direction = direction;
	}

	public TDirection getDirection() {
		return direction;
	}

	public void setTranslating(boolean isTranslating) {
		this.isTranslating = isTranslating;
	}

	public boolean isTranslating() {
		return isTranslating;
	}

}
