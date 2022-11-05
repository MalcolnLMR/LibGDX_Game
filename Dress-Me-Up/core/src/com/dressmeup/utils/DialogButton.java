package com.dressmeup.utils;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dressmeup.entities.Customers;

public class DialogButton extends TextButton {
	
	private int actualDialog = 0;
	private String name;
	private Customers customer;

	public DialogButton(String text, Skin skin, Customers customer) {
		super(text, skin);
		this.setPosition(50, 200);
		this.setSize(200, 100);
		this.customer = customer;		
	}
	
	public int getActualDialog() {
		return actualDialog;
	}
	
	public Customers getCustomer() {
		return customer;
	}

}
