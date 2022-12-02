package com.dressmeup.systems;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dressmeup.entities.AbstractCustomers;
import com.dressmeup.entities.customers.Linda;
import com.dressmeup.entities.customers.Raquel;
import com.dressmeup.game.DressMeUp;
import com.dressmeup.utils.DialogButton;

public class DialogSystem {

	private DressMeUp game;
	private AbstractCustomers raquel, linda;
	private AbstractCustomers actualCustomer;
	
	private int actualDialog;	
	private boolean dialogChanged = false;
	private boolean playerTalking;

	public DialogSystem(DressMeUp game) {
		this.game = game;
		raquel = new Raquel(game);
		linda = new Linda(game);	
	}
	
	public DialogButton getDialogButtonCustomer() {
		DialogButton dialogBox = new DialogButton(game.getSkinManager().getSkin());
		dialogBox.addListener(new ClickListener(Buttons.LEFT) {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				game.getDialogSystem().nextDialog();
			}
		});
		dialogBox.addListener(new ClickListener(Buttons.RIGHT) {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);		
				game.getDialogSystem().previousDialog();
			}
		});
		return dialogBox;
	}
	
	public DialogButton getDialogButtonPlayer() {
		DialogButton dialogBox = new DialogButton(game.getSkinManager().getSkin(), "txtbtn_dialogP");
		dialogBox.addListener(new ClickListener(Buttons.LEFT) {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				game.getDialogSystem().nextDialog();
			}
		});
		dialogBox.addListener(new ClickListener(Buttons.RIGHT) {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);		
				game.getDialogSystem().previousDialog();
			}
		});
		return dialogBox;
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
	
	public void setActualCustomer(AbstractCustomers actualCustomer) {
		this.actualCustomer = actualCustomer;
	}
	
	public AbstractCustomers getActualCustomer() {
		return actualCustomer;
	}

	public int getActualDialog() {
		return actualDialog;
	}

	public void nextDialog() {
		if(actualDialog < actualCustomer.getMaxDialogs() - 1) {
			this.actualDialog++;
			if(actualCustomer.getDialog(actualDialog).startsWith("A:")) playerTalking = true;
			else playerTalking = false;
			dialogChanged = true;
		}
	}
	
	public void previousDialog() {
		if(actualDialog > 0) {
			this.actualDialog--;
			if(actualCustomer.getDialog(actualDialog).startsWith("A:")) playerTalking = true;
			else playerTalking = false;
			dialogChanged = true;
		}
	}

	public boolean isDialogChanged() {
		return dialogChanged;
	}
	
	public void setDialogChanged(boolean dialogChanged) {
		this.dialogChanged = dialogChanged;
	}
	
	public boolean isPlayerTalking() {
		return playerTalking;
	}
}
