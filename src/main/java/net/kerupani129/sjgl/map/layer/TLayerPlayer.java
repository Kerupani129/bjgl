package net.kerupani129.sjgl.map.layer;

import java.util.Properties;

import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.util.Log;

import net.kerupani129.sjgl.map.ItemMap;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.TObjectMap;
import net.kerupani129.sjgl.map.object.TEventDoor;
import net.kerupani129.sjgl.map.object.TEventWarp;
import net.kerupani129.sjgl.map.object.TObject;
import net.kerupani129.sjgl.map.object.TObjectTile;

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

			Log.debug(" TLayerPlayer: setLocation: " + pos);

			TObject player = objectMap.newInstance(type, map, props);
			for ( TObject obj : map.getObjects() ) {

				if ( obj instanceof TEventWarp ) {
					String name = obj.getProperty("name", null);
					if ( pos.equals(name) ) {
						player.setLocation(obj.getX(), obj.getY());
					}
				} else if ( obj instanceof TEventDoor ) {
					String name = obj.getProperty("name", null);
					if ( pos.equals(name) ) {
						player.setLocation(
								((TObjectTile) obj).getLookingX(),
								((TObjectTile) obj).getLookingY());
						((TObjectTile) player).setDirection(
								((TObjectTile) obj).getDirection()
								);
					}
				}

			}
			addObject(player);
			Log.debug(" TLayerPlayer: player");
		}

	}

}
