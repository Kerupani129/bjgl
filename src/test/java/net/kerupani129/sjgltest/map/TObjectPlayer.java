package net.kerupani129.sjgltest.map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TileSet;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.gl.SAnimation;
import net.kerupani129.sjgl.input.SInput;
import net.kerupani129.sjgl.input.SKeyType;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.TObject;
import net.kerupani129.sjgl.map.TObjectTile;
import net.kerupani129.sjgl.map.ai.AITranslationInTiles;
import net.kerupani129.sjgltest.state.GameMenuState;

public class TObjectPlayer extends TObjectTile {

	//
	// フィールド
	//
	private SAnimation animation;

	//
	// コンストラクタ
	//
	public TObjectPlayer(TMap map) {
		super(map);

		addAI(0, new AIControllPlayer(this));

		TileSet set = this.map.getTileSet(0);
		animation = new SAnimation(set.tiles);
		animation.addFrame(500, set.getTileX(17), set.getTileY(17));
		animation.addFrame(500, set.getTileX(65), set.getTileY(65));

	}

	//
	// メソッド
	//
	/**
	 * アニメーションの取得
	 */
	@Override
	protected SAnimation getAnimation() {
		return animation;
	}

}

class AIControllPlayer extends AITranslationInTiles {

	//
	// コンストラクタ
	//
	public AIControllPlayer(TObject obj) {
		super(obj);

		setAbsoluteSpeed(4, 4);
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
				game.enterState(GameMenuState.class, new FadeOutTransition(), new FadeInTransition());
			}
			if ( input.isKeyPressed(SKeyType.OK) ) {
				// game.enterState(StartMenuState.class, new FadeOutTransition(), new FadeInTransition());
			}
			if ( input.isKeyDown(SKeyType.RIGHT) ) {
				startTranslationInTiles(1, 0);
			}
			if ( input.isKeyDown(SKeyType.DOWN) ) {
				startTranslationInTiles(0, 1);
			}
			if ( input.isKeyDown(SKeyType.LEFT) ) {
				startTranslationInTiles(-1, 0);
			}
			if ( input.isKeyDown(SKeyType.UP) ) {
				startTranslationInTiles(0, -1);
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
