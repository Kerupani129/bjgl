package net.kerupani129.sjgl;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.Transition;

import net.kerupani129.sjgl.input.SInput;
import net.kerupani129.sjgl.input.SKeyType;
import net.kerupani129.sjgl.state.SState;

public class SGame extends StateBasedGame {

	//
	// フィールド
	//
    private int maxId = 0;
    private Map<Class<? extends SState>, Integer> map = new HashMap<Class<? extends SState>, Integer>();

	private Transition enterTransition;
	private Transition leaveTransition;

	private SState prevState;

    //
    // コンストラクタ
    //
    /**
     * ゲームの初期化
     */
	public SGame(String name) {
		super(name);

		// 初期状態の State が BasicGameState で初期化されているので、SState に置き換え
		super.addState(new FirstState());

	}

	//
	// メソッド
	//
	/**
	 * カレント SState のタイプ取得
	 */
	public Class<? extends SState> getCurrentStateType() {
		return this.getCurrentState().getClass();
	}

	/**
	 * カレント SState の取得
	 */
	@Override
	public SState getCurrentState() {
		return (SState)super.getCurrentState();
	}

	/**
	 * SState の追加
	 */
	public void addState(SState state) {
		state.initID(maxId);
		map.put(state.getClass(), state.getID());
		super.addState(state);
		maxId++;
	}

	/**
	 * SState の ID 取得
	 */
	public int getStateID(Class<? extends SState> oclass) {
		Integer id = map.get(oclass);
		if ( id == null ) {
			throw new IllegalStateException("SState の ID 取得に失敗しました");
		}
		return id;
	}

	/**
	 * SState を取得
	 */
	public SState getState(Class<? extends SState> oclass) {
		return (SState) super.getState(map.get(oclass));
	}

	/**
	 * State に入る
	 */
	public void enterState(Class<? extends SState> oclass) {
		super.enterState(getStateID(oclass));
	}

	/**
	 * State に入る
	 */
	public void enterState(Class<? extends SState> oclass, Transition leave, Transition enter) {
		if (leave == null) {
			leave = new EmptyTransition();
		}
		if (enter == null) {
			enter = new EmptyTransition();
		}
		super.enterState(getStateID(oclass), leave, enter);
		leaveTransition = leave;
		enterTransition = enter;
	}

	/**
	 * SGame の初期化
	 */
	@Override
	public final void initStatesList(GameContainer container) throws SlickException {
		container.getInput().pause();
		if (container instanceof SContainer) {
			initInput(((SContainer) container).getInput());
		}
		this.initGame(container);
	}

	/**
	 * SGame の初期化
	 */
	protected void initGame(GameContainer container) throws SlickException {
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

	/**
	 *
	 */
	@Override
	protected final void preUpdateState(GameContainer container, int delta) throws SlickException {
		prevState = getCurrentState();
		// TODO: ユーザーが拡張できるようにする
	}

	/**
	 * update 後の処理
	 */
	@Override
	protected final void postUpdateState(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		if ( !leaveTransition.isComplete() ) {
			input.pause();
		}
		if ( enterTransition.isComplete() ) {
			input.resume();
		}
		// TODO: ユーザーが拡張できるようにする
	}

	/**
	 * 親の SContainer 取得
	 */
	@Override
	public SContainer getContainer() {
		return (SContainer)super.getContainer();
	}

	/**
	 *
	 */
	public SState getPrevState() {
		return this.prevState;
	}

}

/**
 * 最初の SState
 */
class FirstState extends SState {

	//
	// コンストラクタ
	//
	public FirstState() {
		super(-1);
	}

	//
	// メソッド
	//
	@Override
	public void init(SContainer container, SGame game) throws SlickException {
	}

	@Override
	public void render(SContainer container, SGame game, Graphics g) throws SlickException {
	}

	@Override
	public void update(SContainer container, SGame game, int delta) throws SlickException {
	}

}
