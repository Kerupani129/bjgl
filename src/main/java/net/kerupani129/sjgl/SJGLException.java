package net.kerupani129.sjgl;

import org.newdawn.slick.SlickException;

public class SJGLException extends SlickException {

	//
	// メソッド
	//
	public SJGLException(String message) {
		super(message);
	}

	public SJGLException(String message, Throwable e) {
		super(message, e);
	}

}