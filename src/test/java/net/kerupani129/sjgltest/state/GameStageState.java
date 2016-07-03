package net.kerupani129.sjgltest.state;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.state.SState;
import net.kerupani129.sjgltest.map.TObjectPlayer;

public class GameStageState extends SState {

	//
	// フィールド
	//
    private TMap map;
    private TObjectPlayer player;

	//
	// メソッド
	//
    /**
     * 初期化
     */
    @Override
    public void init(SContainer container, SGame game) throws SlickException {

    	// マップ読み込み
    	map = new TMap("map/test2.tmx");
    	map.setViewportSize(container.getWidth(), container.getHeight());

    	// TODO: マップに含める
    	player = new TObjectPlayer(map);

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
		map.render(container, game, g);

		player.render(container, game, g);

	}

	/**
	 * 移動
	 */
	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		/*
		// 入力キーチェック
		SInput input = container.getInput();

		if ( input.isKeyPressed(SKeyType.CANCEL) ) {
			game.enterState(GameMenuState.class, new FadeOutTransition(), new FadeInTransition());
		}
		if ( input.isKeyPressed(SKeyType.OK) ) {
			game.enterState(StartMenuState.class, new FadeOutTransition(), new FadeInTransition());
		}
		if ( input.isKeyDown(SKeyType.RIGHT) ) {
			map.translateViewport(4, 0);
		}
		if ( input.isKeyDown(SKeyType.DOWN) ) {
			map.translateViewport(0, 4);
		}
		if ( input.isKeyDown(SKeyType.LEFT) ) {
			map.translateViewport(-4, 0);
		}
		if ( input.isKeyDown(SKeyType.UP) ) {
			map.translateViewport(0, -4);
		}
		*/

		// マップ
		map.update(container, game, delta);

		player.update(container, game, delta);

	}

}
