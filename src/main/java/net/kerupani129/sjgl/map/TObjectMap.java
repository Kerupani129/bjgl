package net.kerupani129.sjgl.map;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import net.kerupani129.sjgl.map.object.TObject;

public class TObjectMap extends HashMap<String, Class<? extends TObject>> {

	//
	// メソッド
	//
	public boolean add(Class<? extends TObject> oclass) {
		String key = oclass.getSimpleName();
		if ( !this.containsKey(key) ) {
			this.put(key, oclass);
			return true;
		} else {
			return false;
		}
	}

	public TObject newInstance(String key, TMap map) {
		try {
			return get(key).getConstructor(TMap.class).newInstance(map);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | NullPointerException e) {
			throw new IllegalStateException("TObject の インスタンス化に失敗しました");
		}
	}

}
