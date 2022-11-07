package com.dressmeup.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dressmeup.game.DressMeUp;

public class Database {
	
	private DressMeUp game;
	
	public Database(DressMeUp game) {
		this.game = game;
	}
	
	public List<String> loadFile(String path) {
		
		List<String> dialog = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String nextDialog = null;
			
			while((nextDialog = reader.readLine()) != null) {
				dialog.add(nextDialog);
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dialog;
	}
	
	public DressMeUp getGame() {
		return game;
	}
}
