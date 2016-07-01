package net.kerupani129.sjgltest.state;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.input.SInput;
import net.kerupani129.sjgl.input.SKeyType;
import net.kerupani129.sjgl.maps.tiled.STiledMap;
import net.kerupani129.sjgl.state.SState;

public class GameStageState extends SState {

	//
	// フィールド
	//
    // TiledMap map;
    STiledMap map;

	//
	// メソッド
	//
    /**
     * 初期化
     */
    @Override
    public void init(SContainer container, SGame game) throws SlickException {

    	// マップ読み込み
    	// map = new TiledMap("map/test2.tmx");
    	map = new STiledMap("map/test2.tmx");
    	map.setToOrtho(container.getWidth(), container.getHeight());

    	System.out.println("GameStageState.init()");

    }

    /**
     * 描画
     */
	@Override
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {

		// マス目描画
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 15; y++) {
				g.drawRect(x * 32 + 1, y * 32 + 1, 32 - 1 - 1 * 2, 32 - 1 - 1 * 2);
			}
		}

		// マップ描画
		// map.render(0, 0);
		map.render(container, game, g);

	}

	/**
	 * 移動
	 */
	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		// 入力キーチェック
		SInput input = container.getInput();

		if ( input.isKeyPressed(SKeyType.CANCEL) ) {
			game.enterState(GameMenuState.class, new FadeOutTransition(), new FadeInTransition());
		} else if ( input.isKeyPressed(SKeyType.OK) ) {
			game.enterState(StartMenuState.class, new FadeOutTransition(), new FadeInTransition());
		}
		if ( input.isKeyDown(SKeyType.RIGHT) ) {
			map.translate(4, 0);
		}
		if ( input.isKeyDown(SKeyType.DOWN) ) {
			map.translate(0, 4);
		}
		if ( input.isKeyDown(SKeyType.LEFT) ) {
			map.translate(-4, 0);
		}
		if ( input.isKeyDown(SKeyType.UP) ) {
			map.translate(0, -4);
		}

		// マップ移動
		map.update(container, game, delta);

	}

}
