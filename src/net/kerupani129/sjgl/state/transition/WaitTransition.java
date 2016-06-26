package net.kerupani129.sjgl.state.transition;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

public class WaitTransition implements Transition {

	//
	// フィールド
	//
	private Color color;
	private int waitTime;

	//
	// コンストラクタ
	//
	public WaitTransition() {
		this(Color.black, 500);
	}

	public WaitTransition(int waitTime) {
		this(Color.black, waitTime);
	}

	public WaitTransition(Color color) {
		this(color, 500);
	}

	public WaitTransition(Color color, int waitTime) {
		this.color = new Color(color);
		this.waitTime = waitTime;
	}

	//
	// メソッド
	//
	@Override
	public void update(StateBasedGame game, GameContainer container, int delta) throws SlickException {
		waitTime -= delta;
	}

	@Override
	public void preRender(StateBasedGame game, GameContainer container, Graphics g) throws SlickException {
	}

	@Override
	public void postRender(StateBasedGame game, GameContainer container, Graphics g) throws SlickException {
		Color old = g.getColor();
		g.setColor(this.color);
		g.fillRect(0.0F, 0.0F, (float) (container.getWidth() * 2), (float) (container.getHeight() * 2));
		g.setColor(old);
	}

	@Override
	public boolean isComplete() {
		return waitTime <= 0;
	}

	@Override
	public void init(GameState firstState, GameState secondState) {

	}

}
