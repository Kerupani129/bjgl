package net.kerupani129.sjgl.map.item;

import java.util.Properties;

import org.newdawn.slick.geom.Point;

import net.kerupani129.sjgl.map.object.TObject;
import net.kerupani129.sjgl.map.object.TObjectTile;

public abstract class Item {

	// コンストラクタ
	public Item(Properties props) {

	}

	// メソッド
	public final void use(TObject player) {

		use(
				new Point(
						((TObjectTile) player).getXInTiles(),
						((TObjectTile) player).getYInTiles()
						),
				new Point(
						((TObjectTile) player).getLookingXInTiles(),
						((TObjectTile) player).getLookingYInTiles()
						)
				);

	}

	public abstract void use(Point player, Point forward);

}
