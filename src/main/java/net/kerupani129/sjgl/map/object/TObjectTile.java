package net.kerupani129.sjgl.map.object;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.kerupani129.sjgl.map.TMap;

public abstract class TObjectTile extends TObject {

	//
	// フィールド
	//
	private TDirection direction = TDirection.DOWN;
	private boolean isTranslating = false;

	private static Map<TDirection, PointInt> dirToPointMap = new HashMap<TDirection, PointInt>(4);

	//
	// コンストラクタ
	//
	{

		dirToPointMap.put(TDirection.RIGHT, new PointInt( 1,  0));
		dirToPointMap.put(TDirection.DOWN , new PointInt( 0,  1));
		dirToPointMap.put(TDirection.LEFT , new PointInt(-1,  0));
		dirToPointMap.put(TDirection.UP   , new PointInt( 0, -1));

	}

	public TObjectTile(TMap map, Properties props) {
		super(map, props);

		setSize(map.getTileWidth(), map.getTileHeight());

		String dir = getProperty("dir", null);
		if ( dir != null ) {
			direction = TDirection.parseDirection(dir);
		}

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

	public int getXInTiles() {
		return (int) ( (this.getX() + this.map.getTileWidth() / 2) / this.map.getTileWidth() );
	}

	public int getYInTiles() {
		return (int) ( (this.getY() + this.map.getTileHeight() / 2) / this.map.getTileHeight() );
	}

	public int getDirXInTiles() {
		PointInt point = dirToPointMap.get(getDirection());
		return point.getX();
	}

	public int getDirYInTiles() {
		PointInt point = dirToPointMap.get(getDirection());
		return point.getY();
	}

	public int getLookingXInTiles() {
		return getXInTiles() + getDirXInTiles();
	}

	public int getLookingYInTiles() {
		return getYInTiles() + getDirYInTiles();
	}

	public float getLookingX() {
		return getX() + getDirXInTiles() * getWidth();
	}

	public float getLookingY() {
		return getY() + getDirYInTiles() * getHeight();
	}

	//
	// インナークラス
	//
	class PointInt {
		private int x = 0, y = 0;
		public PointInt(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() { return x; }
		public int getY() { return y; }
	}

}
