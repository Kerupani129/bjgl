package net.kerupani129.sjgltest.map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TileSet;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.ai.TAITranslationInTiles;
import net.kerupani129.sjgl.map.object.TDirection;
import net.kerupani129.sjgl.map.object.TObjectCharactor;
import net.kerupani129.sjgl.map.object.TObjectTile;

public class TObjectEnemy extends TObjectCharactor {

	//
	// コンストラクタ
	//
	public TObjectEnemy(TMap map) {
		super(map);

		addAI(0, new TAIEnemyTest(this));

		TileSet set = this.map.getTileSet("bng");

		setCharactorAnimation(set.tiles);

	}

}

class TAIEnemyTest extends TAITranslationInTiles {

	//
	// フィールド
	//
	private int steps = 0;

	//
	// コンストラクタ
	//
	public TAIEnemyTest(TObjectEnemy obj) {
		super(obj);
	}

	//
	// メソッド
	//
	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {

		// タイル間を移動中なら新たな移動を始めない
		if ( !isTranslating() ) {

			// 移動開始
			// TODO: 絶対ちゃんと動くかどうか不安 (汗
			TObjectPlayer player = (TObjectPlayer) obj.map.getPlayers().get(0);

			if (steps % 2 == 0) {
				if ( ((TObjectTile) obj).getXInTiles() < player.getXInTiles() )
					startTranslationInOneTile(TDirection.RIGHT);
				if ( ((TObjectTile) obj).getXInTiles() > player.getXInTiles() )
					startTranslationInOneTile(TDirection.LEFT);
			} else {
				if ( ((TObjectTile) obj).getYInTiles() < player.getYInTiles() )
					startTranslationInOneTile(TDirection.DOWN);
				if ( ((TObjectTile) obj).getYInTiles() > player.getYInTiles() )
					startTranslationInOneTile(TDirection.UP);
			}

			steps++;

		}

	}

}
