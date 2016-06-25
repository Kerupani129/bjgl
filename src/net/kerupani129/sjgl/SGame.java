package net.kerupani129.sjgl;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import net.kerupani129.sjgl.input.SInput;
import net.kerupani129.sjgl.input.SKeyType;
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
	public void addState(SState state) {
		state.initID(maxId);
		map.put(state.getClass(), state.getID());
		super.addState(state);
		maxId++;
	}

	/**
	 * State に入る
	 */
	public void enterState(Class<? extends SState> oclass) {
		Integer id = map.get(oclass);
		if ( id == null ) {
			throw new IllegalStateException("SState の enter に失敗");
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

	/**
	 * 親の SContainer 取得
	 */
	@Override
	public SContainer getContainer() {
		GameContainer container = super.getContainer();
		if ( container instanceof SContainer ) return (SContainer)container;
		throw new IllegalStateException("SGame が SContainer 以外に持たれている");
	}

	/**
	 * SInput の初期化
	 */
	public void initInput(SInput input) {

		// キー設定
		input.addKey(SKeyType.OK, (key) -> {
			key.add(Input.KEY_Z);
			key.add(Input.KEY_ENTER);
			key.add(Input.KEY_SPACE);
		});

		input.addKey(SKeyType.CANCEL, (key) -> {
			key.add(Input.KEY_X);
			key.add(Input.KEY_ESCAPE);
		});

		input.addKey(SKeyType.UP, (key) -> {
			key.add(Input.KEY_UP);
		});

		input.addKey(SKeyType.DOWN, (key) -> {
			key.add(Input.KEY_DOWN);
		});

		input.addKey(SKeyType.LEFT, (key) -> {
			key.add(Input.KEY_LEFT);
		});

		input.addKey(SKeyType.RIGHT, (key) -> {
			key.add(Input.KEY_RIGHT);
		});

	}

}
