package net.kerupani129.sjgl.map.layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.tiled.TileSet;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.TObjectMap;
import net.kerupani129.sjgl.map.object.TObject;

public class TLayerObject extends TLayer {

	//
	// フィールド
	//
	private List<TObject> objectList = new ArrayList<TObject>();

	//
	// コンストラクタ
	//
	public TLayerObject(TMap map, Layer layer, TObjectMap objectMap) {
		super(map, layer);

		parseObjects(objectMap);
	}

	//
	// メソッド
	//
	protected void parseObjects(TObjectMap objectMap) {

		// TObject をパース
		for (int x = 0; x < layer.width; x++) {
			for (int y = 0; y < layer.height; y++) {

				// id type
				int tileID = layer.getTileID(x, y);
				String type = map.getTileProperty(tileID, "type", null);

				// props
				Properties props = new Properties();
				if ( tileID != 0 ) {
					TileSet set = map.findTileSet(tileID);
					Properties t = set.getProperties(tileID);
					if (t != null) props.putAll(t);
				}
				props.setProperty("tileID", "" + tileID);

				// インスタンス
				if ( type != null ) {
					TObject object = objectMap.newInstance(type, map, props);
					object.setLocation(x * map.getTileWidth(), y * map.getTileHeight());
					addObject(object);
				}

			}
		}

	}

	@Override
	public void render(int x, int y, int sx, int sy, int width, int height, boolean lineByLine) {
		for (TObject object : objectList) {
			object.render();
		}
	}

	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {
		for (TObject object : objectList) {
			object.update(container, game, delta);
		}
	}

	protected boolean addObject(TObject object) {
		return objectList.add(object);
	}

	public List<TObject> getObjects() {
		return objectList;
	}

	public List<TObject> getObjects(String type) {
		List<TObject> list = new ArrayList<TObject>();
		for (TObject obj : objectList) {
			if ( obj.getClass().getSimpleName().equals(type) ) {
				list.add(obj);
			}
		}
		return list;
	}

}
