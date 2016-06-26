package net.kerupani129.sjgl.input;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Input;

public class SInput extends Input {

	//
	// フィールド
	//
    private Map<SKeyTypeI, SKey> map = new HashMap<SKeyTypeI, SKey>();

	//
	// コンストラクタ
	//
	/**
	 * 初期化
	 */
	public SInput(int height) {
		super(height);
	}

	//
	// メソッド
	//
	/**
	 * SKey の追加
	 */
	public void addKey(SKeyTypeI type, SKeyInitI init) {
		SKey key = new SKey(type, init);
		map.put(type, key);
	}

	/**
	 * SKey の取得
	 */
	public SKey getKey(SKeyTypeI type) {
		SKey key = map.get(type);
		if ( key == null ) {
			throw new IllegalStateException("SKey の取得に失敗しました");
		}
		return key;
	}

	/**
	 * キーが押されたかチェック
	 */
	public boolean isKeyPressed(SKeyTypeI type) {

		SKey key = getKey(type);
		boolean result = false;

		for (int code : key) {
			result |= super.isKeyPressed(code);
		}

		return result;

	}

	/**
	 * キーが押し下げられたかチェック
	 */
	public boolean isKeyDown(SKeyTypeI type) {

		SKey key = getKey(type);
		boolean result = false;

		for (int code : key) {
			result |= super.isKeyDown(code);
		}

		return result;

	}

}