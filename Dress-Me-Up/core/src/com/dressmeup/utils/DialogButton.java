package com.dressmeup.utils;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dressmeup.configs.GameConfigs;
import com.dressmeup.entities.AbstractCustomers;

public class DialogButton extends TextButton {
	
	private AbstractCustomers customer;
	private final int WIDTH = GameConfigs.getScaledWidth() - 500;
	private final int HEITH = 300;

	public DialogButton(Skin skin, AbstractCustomers customer) {
		super("", skin, "txtbtn_dialogC");
		this.setPosition(10, 10);
		this.setSize(WIDTH, HEITH);
		this.customer = customer;
		setActualDialog(0);
	}
	
	public DialogButton(Skin skin) {
		super("", skin, "txtbtn_dialogC");
		this.setPosition(10, 10);
		this.setSize(WIDTH, HEITH);
	}
	
	public DialogButton(Skin skin, String id) {
		super("", skin, id);
		this.setPosition(10, 10);
		this.setSize(WIDTH, HEITH);
	}
	
	public void setActualDialog(int index) {
		this.setText(customer.getDialogFormated(index));
	}
	
	public AbstractCustomers getCustomer() {
		return customer;
	}
	
	public void setCustomer(AbstractCustomers customer) {
		this.customer = customer;
		setActualDialog(0);
	}

}
