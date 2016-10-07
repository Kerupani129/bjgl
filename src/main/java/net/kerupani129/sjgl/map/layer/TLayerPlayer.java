package net.kerupani129.sjgl.map.layer;

import java.util.Properties;

import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.util.Log;

import net.kerupani129.sjgl.map.ItemMap;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.TObjectMap;
import net.kerupani129.sjgl.map.object.TEventWarp;
import net.kerupani129.sjgl.map.object.TObject;

public class TLayerPlayer extends TLayerObject {

	//
	// コンストラクタ
	//
	public TLayerPlayer(TMap map, Layer layer, String pos, TObjectMap objectMap, ItemMap itemMap) {
		super(map, layer, objectMap, itemMap);

		parsePlayers(pos, objectMap);
	}

	//
	// メソッド
	//
	protected void parsePlayers(String pos, TObjectMap objectMap) {

		// id type
		String type = map.getMapProperty("player", null);

		// props
		Properties props = new Properties();

		// インスタンス
		if ( type != null ) {

			TObject object = objectMap.newInstance(type, map, props);
			for ( TObject obj : map.getObjects() ) {
				if ( obj instanceof TEventWarp ) {
					Log.debug(" TLayerPlayer: setLocation: " + pos);
					String name = obj.getProperty("name", null);
					if ( pos.equals(name) ) {
						object.setLocation(obj.getX(), obj.getY());
					}
				}
			}
			addObject(object);
			Log.debug(" TLayerPlayer: player");
		}

	}

}
