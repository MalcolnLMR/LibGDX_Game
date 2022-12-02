package com.dressmeup.entities;

import java.io.File;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.dressmeup.game.DressMeUp;

public abstract class AbstractCustomers {
	
	protected String name;
	protected DressMeUp game;
	protected List<String> dialogs;
	protected int maxDialogs;
	
	public AbstractCustomers(DressMeUp game) {
		this.game = game;		
	}
		
	public abstract String getDialog(int index);
	public abstract String getDialogFormated(int index);
	
	protected void loadDialogs(String fileName) {
		dialogs = game.getDatabase().loadFile(Gdx.files.getLocalStoragePath() + "characters" + File.separator + fileName);	
		maxDialogs = dialogs.size();
	}
	
	public int getMaxDialogs() {
		return maxDialogs;
	}
	
	public String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}

}
