package net.kerupani129.sjgl.map.item;

import java.util.Properties;

import net.kerupani129.sjgl.map.object.TObject;

public abstract class Item {

	// コンストラクタ
	public Item(Properties props) {

	}

	// メソッド
	public abstract void use(TObject player);

}
