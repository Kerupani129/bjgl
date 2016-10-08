package net.kerupani129.sjgl.map.object;

public enum TDirection {

	//
	// フィールド
	//
	DOWN, LEFT, RIGHT, UP;

	//
	// メソッド
	//
    public static TDirection parseDirection(String s) {

        switch (s.toLowerCase()) {
        case "down":
        	return DOWN;
        case "left":
        	return LEFT;
        case "right":
        	return RIGHT;
        case "up":
        	return UP;
        }

        throw new IllegalArgumentException("TDirection のパースに失敗: \"" + s + "\"");

    }

}
