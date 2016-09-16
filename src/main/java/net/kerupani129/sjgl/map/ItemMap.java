package net.kerupani129.sjgl.map;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

import net.kerupani129.sjgl.map.item.Item;

public class ItemMap extends HashMap<String, Class<? extends Item>> {

	//
	// メソッド
	//
	public boolean add(Class<? extends Item> oclass) {
		String key = oclass.getSimpleName();
		if ( !this.containsKey(key) ) {
			this.put(key, oclass);
			return true;
		} else {
			return false;
		}
	}

	public Item newInstance(String key, Properties props) {
		try {
			Item obj = get(key).getConstructor(Properties.class).newInstance(props);
			return obj;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | NullPointerException e) {
			throw new IllegalStateException("TObject の インスタンス化に失敗しました");
		}
	}

}
