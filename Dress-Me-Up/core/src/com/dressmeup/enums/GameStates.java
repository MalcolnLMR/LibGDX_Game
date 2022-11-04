package com.dressmeup.enums;

public enum GameStates {
	
	MENU(1), GAME(2), PAUSE(3), TELEPHONE(4), EXIT(4);	
	
	private int value;
	
	GameStates(int num){
		this.value = num;
	}

	public int getValue() {
		return value;
	}	
}
