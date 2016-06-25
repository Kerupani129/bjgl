package net.kerupani129.sjgl.input;

import java.util.HashSet;

public class SKey extends HashSet<Integer> {

	//
	// フィールド
	//
	private SKeyTypeI type;

	//
	// コンストラクタ
	//
	/**
	 * 初期化
	 */
	public SKey(SKeyTypeI type, SKeyInitI init) {
	    this.type = type;
	    init.init(this);
	}

	//
	// メソッド
	//
	/**
	 * Type 取得
	 */
	public SKeyTypeI getType() {
		return type;
	}

}
