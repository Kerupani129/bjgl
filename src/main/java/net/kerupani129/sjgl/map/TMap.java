package net.kerupani129.sjgl.map;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;

// TODO: マップファイルの仕様通りに拡張する (現在は最低限の機能しかない)
public class TMap extends TiledMap {

	//
	// フィールド
	//
	private float maxMapX = 0, maxMapY = 0;
    private Rectangle viewport = new Rectangle(0, 0, 0, 0);

	//
	// コンストラクタ
	//
	/**
	 * パス文字列から TiledMap を読み込む
	 */
	public TMap(String path) throws SlickException {
		super(path, getParent(path));
	}

	//
	// メソッド
	//
	/**
	 * 親ディレクトリ取得
	 */
	private static String getParent(String path) {
		Path opath = Paths.get(path);
		String parent = opath.getParent().toString();
		parent = parent.replace('\\', '/');
		return parent;
	}

	/**
	 * マップ表示移動
	 */
	public void translateViewport(float x, float y) {
		this.setViewportLocation(viewport.getX() + x, viewport.getY() + y);
	}

	/**
	 * 描画エリアサイズ設定
	 */
	public void setViewportSize(float viewportWidth, float viewportHeight) {
		viewport.setSize(viewportWidth, viewportHeight);

		maxMapX = this.getTileWidth()  * this.getWidth()  - viewport.getWidth();
		maxMapY = this.getTileHeight() * this.getHeight() - viewport.getHeight();

		if (maxMapX < 0) maxMapX = 0;
		if (maxMapY < 0) maxMapY = 0;
	}

	/**
	 * 描画エリア一位置設定
	 */
	public void setViewportLocation(float viewportX, float viewportY) {

		if (viewportX < 0) viewportX = 0;
		if (viewportY < 0) viewportY = 0;
		if (viewportX > maxMapX) viewportX = maxMapX;
		if (viewportY > maxMapY) viewportY = maxMapY;

		viewport.setLocation(viewportX, viewportY);
	}

	/**
	 * 描画エリア一取得
	 */
	public Rectangle getViewport() {
		return new Rectangle(viewport.getX(), viewport.getY(), viewport.getWidth(), viewport.getHeight());
	}

    /**
     * 描画
     */
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {
		g.translate(-viewport.getX(), -viewport.getY());
		g.setWorldClip(viewport);
		super.render(0, 0);
	}

	/**
	 * 移動
	 */
	public void update(SContainer container, SGame game, int delta) throws SlickException {

	}

}
