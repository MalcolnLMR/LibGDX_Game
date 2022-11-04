package com.dressmeup.systems;

import com.dressmeup.enums.GameStates;
import com.dressmeup.game.DressMeUp;
import com.dressmeup.gamestates.StateGame;
import com.dressmeup.gamestates.StateMenu;
import com.dressmeup.gamestates.StatePause;

public class GameStateSystem {
	
	private GameStates actualState;
	private StateMenu menu;
	private StateGame game;
	private StatePause pause;
	
	public GameStateSystem(DressMeUp game) {
		this.actualState = GameStates.MENU;
		this.menu = new StateMenu(game);
		this.game = new StateGame(game);
		this.pause = new StatePause(game);		
	}
	
	public void dispose() {
		menu.dispose();
		game.dispose();
		pause.dispose();
	}
	
	public void setActualState(GameStates game) {
		switch (game) {
			case MENU:
				getMenu().create();
				break;
			case GAME:
				getGame().create();
				break;
			case PAUSE:
				getPause().create();
				break;
			default:				
				break;
		}
		this.actualState = game;
	}

	public GameStates getActualState() {
		return actualState;
	}

	public StateMenu getMenu() {
		return menu;
	}

	public StateGame getGame() {
		return game;
	}

	public StatePause getPause() {
		return pause;
	}
}
