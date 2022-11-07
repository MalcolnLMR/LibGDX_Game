package com.dressmeup.systems;

import com.dressmeup.entities.AbstractCustomers;
import com.dressmeup.entities.customers.Linda;
import com.dressmeup.entities.customers.Raquel;
import com.dressmeup.game.DressMeUp;

public class CustomerSystem {

	private DressMeUp game;
	private AbstractCustomers raquel, linda;	

	public CustomerSystem(DressMeUp game) {
		this.game = game;
		raquel = new Raquel(game);
		linda = new Linda(game);	
	}

	public DressMeUp getGame() {
		return game;
	}

	public AbstractCustomers getRaquel() {
		return raquel;
	}

	public AbstractCustomers getLinda() {
		return linda;
	}
}
