package com.dressmeup.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.dressmeup.game.DressMeUp;

public class Database {
	
	private DressMeUp game;
	private List<String> raquelDialog;
	
	public Database(DressMeUp game) {
		this.game = game;
		loadRaquel();
	}
	
	public void loadRaquel() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\fatecscs\\Documents\\GitHub\\LibGDX_Game\\Dress-Me-Up\\assets\\characters\\Raquel.txt"));
			
			String nextDialog = null;
			
			while((nextDialog = reader.readLine()) != null) {
				raquelDialog.add(nextDialog);
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DressMeUp getGame() {
		return game;
	}
	
	public List<String> getRaquelDialog() {
		return raquelDialog;
	}

}
