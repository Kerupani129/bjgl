package net.kerupani129.sjgl.map.object;

import java.util.Properties;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TileSet;

import net.kerupani129.sjgl.gl.SAnimation;
import net.kerupani129.sjgl.map.TMap;

public class TObjectCharactor extends TObjectTile {

	//
	// フィールド
	//
	private SAnimation[] animeationArray = new SAnimation[4];

	//
	// コンストラクタ
	//
	public TObjectCharactor(TMap map, Properties props) {
		super(map, props);

		int tileID = getTileID();
		TileSet set = map.findTileSet(tileID);

		if ( set != null ) setCharactorAnimation(set.tiles);

	}

	//
	// メソッド
	//
	@Override
	protected SAnimation getAnimation() {
		return getCharactorAnimation();
	}

	protected void setCharactorAnimation(SpriteSheet ss) {
		setCharactorAnimation(ss, 125);
	}

	// TODO: 複数キャラが一枚の SpriteSheet になっている場合に対応が必要
	protected void setCharactorAnimation(SpriteSheet ss, int duration) {
		for (int i = 0; i < animeationArray.length; i++) {
			animeationArray[i] = new SAnimation(ss);

			animeationArray[i].addFrame(duration, 0, i);
			animeationArray[i].addFrame(duration, 1, i);
			animeationArray[i].addFrame(duration, 2, i);
			animeationArray[i].addFrame(duration, 1, i);

			animeationArray[i].stopAt(3);

		}
	}

	protected SAnimation getCharactorAnimation() {
		SAnimation animation = animeationArray[getDirection().ordinal()];
		if ( this.isTranslating() ) {
			if ( animation.isStopped() ) {
				animation.restart();
			}
		} else {
			if ( !animation.isStopped() ) {
				animation.stop();
			} else {
				animation.setCurrentFrame(3);
			}
		}
		return animation;
	}

}
