package net.kerupani129.sjgl.map;

import org.newdawn.slick.tiled.Layer;

public class TLayerTile extends TLayer {

	//
	// コンストラクタ
	//
	public TLayerTile(TMap map, Layer layer) {
		super(map, layer);
	}

	//
	// メソッド
	//
	public void render(int x, int y, int sx, int sy, int width, int height, boolean lineByLine) {
		switch (map.getOrientation()) {
		case 1:
			for (int ty = 0; ty < height; ++ty) {
				this.layer.render(x, y, sx, sy, width, ty, lineByLine, map.getTileWidth(), map.getTileHeight());
			}

			return;
		case 2:
			map.renderIsometricMap(x, y, sx, sy, width, height, this.layer, lineByLine);
		}
	}

}
