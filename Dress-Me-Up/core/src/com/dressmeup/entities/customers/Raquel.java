package com.dressmeup.entities.customers;

import com.dressmeup.entities.AbstractCustomers;
import com.dressmeup.game.DressMeUp;

public class Raquel extends AbstractCustomers{
	
	public Raquel(DressMeUp game) {
		super(game);
		setName("Raquel");
		loadDialogs("Raquel.txt");
	}	
	
	@Override
	public String getDialog(int index) {
		return dialogs.get(index);
	}

	@Override
	public String getDialogFormated(int index) {
		return dialogs.get(index).replace("A: ", "").replace("R: ", "");
	}
}
