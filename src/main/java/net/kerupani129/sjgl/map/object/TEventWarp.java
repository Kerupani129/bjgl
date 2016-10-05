package net.kerupani129.sjgl.map.object;

import java.util.List;
import java.util.Properties;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.tokyotech.trap.lib.state.SStateGameStage;

import net.kerupani129.sjgl.SContainer;
import net.kerupani129.sjgl.SGame;
import net.kerupani129.sjgl.map.TMap;

public class TEventWarp extends TEvent {

	// コンストラクタ
	public TEventWarp(TMap map, Properties props) {
		super(map, props);
	}

	// メソッド
	public void eventUpdate(SContainer container, SGame game, int delta) throws SlickException {

		List<TObject> players = map.getPlayers();

		for (TObject player : players) {
			if ( overlapedWith(player) ) {
				String path = getProperty("map", null);
				map.manager.enterMap(path);
				game.enterState(SStateGameStage.class, new FadeOutTransition(), new FadeInTransition());
			}
		}

	}

}
