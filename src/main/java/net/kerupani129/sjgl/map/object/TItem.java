package net.kerupani129.sjgl.map.object;

import java.util.Properties;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TileSet;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.gl.SAnimation;
import net.kerupani129.sjgl.map.TMap;
import net.kerupani129.sjgl.map.item.Item;

// TODO: 未実装
public class TItem extends TEvent {

	// フィールド
	private SAnimation animation;

	// private Item item;

	// コンストラクタ
	public TItem(TMap map, Properties props) {
		super(map, props);

		// マップチップ設定
		int tileID = getTileID();
		TileSet set = map.findTileSet(tileID);
		int localID = tileID - set.firstGID;

		int sheetX = set.getTileX(localID);
		int sheetY = set.getTileY(localID);

		animation = new SAnimation(set.tiles);
		animation.addFrame(Integer.MAX_VALUE, sheetX, sheetY);

	}

	// メソッド
	public void setItem (Item item) {

		// 物理的なアイテムではなく、使用時の処理などが書かれたクラスのインスタンス
		// this.item = item;

	}

	@Override
	protected SAnimation getAnimation() {
		return animation;
	}

	@Override
	public void eventUpdate(SContainer container, SGame game, int delta) throws SlickException {

	}

}
