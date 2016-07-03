package net.kerupani129.sjgl.map;

public abstract class TObjectTile extends TObject {

	//
	// コンストラクタ
	//
	public TObjectTile(TMap map) {
		super(map);
		setSize(map.getTileWidth(), map.getTileHeight());
	}

}
