package net.kerupani129.sjgl.map;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.Layer;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;

public class TLayerObject extends TLayer {

	//
	// フィールド
	//
	List<TObject> objectList = new ArrayList<TObject>();

	//
	// コンストラクタ
	//
	public TLayerObject(TMap map, Layer layer, TObjectMap objectMap) {
		super(map, layer);

		// TObject をパース
		for (int x = 0; x < layer.width; x++) {
			for (int y = 0; y < layer.width; y++) {
				int tileID = layer.getTileID(x, y);
				String type = map.getTileProperty(tileID, "type", null);
				if ( type != null ) {
					TObject object = objectMap.newInstance(type, map);
					object.setLocation(x * map.getTileWidth(), y * map.getTileHeight());
					objectList.add(object);
				}
			}
		}
	}

	//
	// メソッド
	//
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

}
