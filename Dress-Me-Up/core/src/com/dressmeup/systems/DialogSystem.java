package com.dressmeup.systems;

import com.dressmeup.game.DressMeUp;

// Controlar todo o sistema de diálogo, carregando salvando e td mais

public class DialogSystem {

	private DressMeUp game;

	public DialogSystem(DressMeUp game) {
		this.game = game;
		
	}

	public DressMeUp getGame() {
		return game;
	}

}
