package net.kerupani129.sjgltest.state;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.map.TMapManager;
import net.kerupani129.sjgl.map.TObjectMap;
import net.kerupani129.sjgl.state.SState;
import net.kerupani129.sjgltest.map.TObjectEnemy;
import net.kerupani129.sjgltest.map.TObjectPlayer;

public class SStateGameStage extends SState {

	//
	// フィールド
	//
    private TMapManager mapManager;

	//
	// メソッド
	//
    /**
     * 初期化
     */
    @Override
    public void init(SContainer container, SGame game) throws SlickException {

    	// マップに出現させるオブジェクトのリスト
    	TObjectMap objectMap = new TObjectMap();
    	objectMap.add(TObjectPlayer.class);
    	objectMap.add(TObjectEnemy.class);

    	// マップ準備
    	mapManager = new TMapManager("map", objectMap);

    }

    /**
     * 描画
     */
	@Override
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {

		// マップ描画
		mapManager.render(container, game, g);

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
		mapManager.update(container, game, delta);

	}

	/**
	 * シーン開始時
	 */
	@Override
	public void enter(SContainer container, SGame game) throws SlickException {
		if ( game.getPrevState() instanceof SStateGameMenu ) return;
		if ( game.getPrevState() instanceof SStateStartMenu )
	    	mapManager.enterMap("test4.tmx");
		mapManager.enter(container, game);
	}

}
