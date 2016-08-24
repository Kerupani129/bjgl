package net.kerupani129.sjgltest.map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TileSet;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.input.SInput;
import net.kerupani129.sjgl.input.SKeyType;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.ai.TAITranslationInTiles;
import net.kerupani129.sjgl.map.object.TDirection;
import net.kerupani129.sjgl.map.object.TObjectCharactor;
import net.kerupani129.sjgltest.state.SStateGameMenu;
import net.kerupani129.sjgltest.state.SStateGameStage;

public class TObjectPlayer extends TObjectCharactor {

	//
	// コンストラクタ
	//
	public TObjectPlayer(TMap map) {
		super(map);

		addAI(0, new TAIControllPlayer(this));

		TileSet set = this.map.getTileSet("bng");

		setCharactorAnimation(set.tiles);

	}

}

class TAIControllPlayer extends TAITranslationInTiles {

	//
	// コンストラクタ
	//
	public TAIControllPlayer(TObjectPlayer obj) {
		super(obj);
	}

	//
	// メソッド
	//
	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		// タイル間を移動中ならキー入力を受け付けない
		if ( !isTranslating() ) {

			// 入力キーチェック
			SInput input = container.getInput();

			if ( input.isKeyPressed(SKeyType.CANCEL) ) {
				game.enterState(SStateGameMenu.class, new FadeOutTransition(), new FadeInTransition());
			}
			if ( input.isKeyPressed(SKeyType.OK) ) {
				// マップ切り替え処理
				obj.map.manager.enterMap("test4.tmx");
				game.enterState(SStateGameStage.class, new FadeOutTransition(), new FadeInTransition());
			}
			if ( input.isKeyDown(SKeyType.RIGHT) ) {
				startTranslationInOneTile(TDirection.RIGHT);
			}
			if ( input.isKeyDown(SKeyType.DOWN) ) {
				startTranslationInOneTile(TDirection.DOWN);
			}
			if ( input.isKeyDown(SKeyType.LEFT) ) {
				startTranslationInOneTile(TDirection.LEFT);
			}
			if ( input.isKeyDown(SKeyType.UP) ) {
				startTranslationInOneTile(TDirection.UP);
			}

		}

		// マップ移動
		Rectangle rect = obj.map.getViewport();
		obj.map.setViewportLocation(
				obj.getX() - (rect.getWidth()  - obj.getWidth() ) / 2,
				obj.getY() - (rect.getHeight() - obj.getHeight()) / 2
				);

	}

}
