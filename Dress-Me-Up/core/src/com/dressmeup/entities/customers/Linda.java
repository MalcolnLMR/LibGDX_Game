package com.dressmeup.entities.customers;

import com.dressmeup.entities.AbstractCustomers;
import com.dressmeup.game.DressMeUp;

public class Linda extends AbstractCustomers {
		
	public Linda(DressMeUp game) {
		super(game);
		setName("Linda");
		loadDialogs("Raquel.txt");
	}	
	
	@Override
	public String getDialog(int index) {
		return dialogs.get(index);
	}
	
	@Override
	public String getDialogFormated(int index) {
		return dialogs.get(index).replace("A: ", "").replace("L: ", "");
	}
}
