package net.kerupani129.sjgl;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import net.kerupani129.sjgl.state.SState;

public class SGame extends StateBasedGame {

	//
	// フィールド
	//
    private int maxId = 0;
    private Map<Class<? extends SState>, Integer> map = new HashMap<Class<? extends SState>, Integer>();

    //
    // コンストラクタ
    //
    /**
     * ゲームの初期化
     */
	public SGame(String name) {
		super(name);
	}

	//
	// メソッド
	//
	/**
	 * State の追加
	 */
	public void addState(Class<? extends SState> oclass) {

		SState ostate;
		try {
			ostate = oclass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalStateException("State のインスタンス化に失敗", e);
		}

		ostate.initID(maxId);
		map.put(oclass, maxId);
		super.addState(ostate);
		maxId++;

	}

	/**
	 * State に入る
	 */
	public void enterState(Class<? extends SState> oclass) {
		Integer id = map.get(oclass);
		if ( id == null ) {
			throw new IllegalStateException("State の enter に失敗");
		}
		super.enterState(id);
	}

	/**
	 * State の初期化
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		for (int id : map.values()) {
	        getState(id).init(container, this);
		}
	}

}
