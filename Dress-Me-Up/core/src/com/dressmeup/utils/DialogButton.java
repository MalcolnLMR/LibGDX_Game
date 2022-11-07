package com.dressmeup.utils;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dressmeup.entities.AbstractCustomers;

public class DialogButton extends TextButton {
	
	private AbstractCustomers customer;

	public DialogButton(Skin skin, AbstractCustomers customer) {
		super("", skin);
		this.setPosition(10, 10);
		this.setSize(450, 200);
		this.customer = customer;
		setActualDialog(0);
	}
	
	public void setActualDialog(int index) {
		this.setText(customer.getDialog(index));
	}
	
	public AbstractCustomers getCustomer() {
		return customer;
	}

}
