package net.kerupani129.sjgl.map;

import java.io.File;
import java.util.HashMap;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;

public class TMapManager extends HashMap<String, TMap> {

	//
	// フィールド
	//
	private String mapDir;
	private TObjectMap objectMap;

	private TMap currentMap, nextMap;

	//
	// コンストラクタ
	//
	public TMapManager(String mapDir, TObjectMap objectMap) {
		this.mapDir = mapDir;
		this.objectMap = objectMap;
	}

	//
	// メソッド
	//
	public static String getName(String path) {

		// 拡張子を除去
		int index = path.lastIndexOf('.');
		if (index != -1) {
			path = path.substring(0, index);
		}

		// ディレクトリ区切り文字を "." (ピリオド) に置換
		path.replaceAll("/", ".");
		path.replaceAll("\\", ".");

		return path;

	}

	public void render(SContainer container, SGame game, Graphics g) throws SlickException {
		currentMap.render(container, game, g);
	}

	public void update(SContainer container, SGame game, int delta) throws SlickException {
		currentMap.update(container, game, delta);
	}

	public void enterMap(String path) throws SlickException {
		nextMap = new TMap(this, new File(mapDir, path).getPath(), objectMap);
		Log.debug(" TMapManager: enterMap(\"" + path + "\")");
	}

	public void enter(GameContainer container, StateBasedGame game) {
		currentMap = nextMap;
		nextMap = null;
		currentMap.setViewportSize(container.getWidth(), container.getHeight());
		Log.debug(" TMapManager: enter");
	}

}