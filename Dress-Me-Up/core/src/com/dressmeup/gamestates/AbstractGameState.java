package com.dressmeup.gamestates;



public abstract class AbstractGameState {		
	public abstract void create();
	public abstract void render();	
	public abstract void tick();	
	public abstract void dispose();	
}
