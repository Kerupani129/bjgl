package net.kerupani129.sjgl.gl;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class SFont extends TrueTypeFont {

	//
	// フィールド
	//
	private String text;

	//
	// コンストラクタ
	//
	/**
	 * フォントの生成
	 *
	 * @param font - Java の AWT の Font
	 * @param antiAlias - アンチエイリアスする
	 * @param text - デフォルト文字列
	 */
	public SFont(java.awt.Font font, boolean antiAlias, String text) {
		super(font, antiAlias, text.toCharArray());
		this.text = text;
	}

	//
	// メソッド
	//
	/**
	 * デフォルト文字列描画
	 */
	public void drawString(float x, float y, Color color) {
		super.drawString(x, y, text, color);
	}

	/**
	 * デフォルト文字列描画
	 */
	public void drawString(float x, float y, Color color, int startIndex, int endIndex) {
		super.drawString(x, y, text, color, startIndex, endIndex);
	}

	/**
	 * デフォルト文字列描画
	 */
	public void drawString(float x, float y) {
		super.drawString(x, y, text);
	}

	/**
	 * デフォルト文字列の高さ取得
	 */
	public int getHeight() {
		return super.getHeight(text);
	}

	/**
	 * デフォルト文字列の幅取得
	 */
	public int getWidth() {
		return super.getWidth(text);
	}

}
