package net.kerupani129.sjgl.maps.tiled;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;

// TODO: マップが画面より小さいときに対応する
// TODO: マップファイルの使用通りに拡張する (現在は最低限の機能しかない)
public class STiledMap extends TiledMap {

	//
	// フィールド
	//
	private float maxX = 0, maxY = 0;
	private int viewportWidthInTiles = 0, viewportHeightInTiles = 0;
    private Rectangle viewport = new Rectangle(0, 0, 0, 0);

	//
	// コンストラクタ
	//
	/**
	 * パス文字列から TiledMap を読み込む
	 */
	public STiledMap(String path) throws SlickException {
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
	public void translate(float x, float y) {
		float newX = viewport.getX() + x;
		float newY = viewport.getY() + y;

		if (newX < 0) newX = 0;
		if (newY < 0) newY = 0;
		if (newX > maxX) newX = maxX;
		if (newY > maxY) newY = maxY;

		viewport.setLocation(newX, newY);
	}

	/**
	 * 描画エリア設定
	 */
	public void setToOrtho(float viewportWidth, float viewportHeight) {
		viewport.setSize(viewportWidth, viewportHeight);

		viewportWidthInTiles  = (int) (viewport.getWidth()  / this.getTileWidth() ) + 1;
		viewportHeightInTiles = (int) (viewport.getHeight() / this.getTileHeight()) + 1;

		maxX = this.getTileWidth()  * this.getWidth()  - viewportWidthInTiles;
		maxY = this.getTileHeight() * this.getHeight() - viewportHeightInTiles;

		System.out.println("viewportWidthInTiles  = " + viewportWidthInTiles);
		System.out.println("viewportHeightInTiles = " + viewportHeightInTiles);
	}

    /**
     * 描画
     */
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {
		super.render(
				(int) -(viewport.getX() % this.getTileWidth()),
				(int) -(viewport.getY() % this.getTileHeight()),

				(int) (viewport.getX() / this.getTileWidth()),
				(int) (viewport.getY() / this.getTileHeight()),

				viewportWidthInTiles, viewportHeightInTiles
				);
	}

	/**
	 * 移動
	 */
	public void update(SContainer container, SGame game, int delta) throws SlickException {

	}

}
