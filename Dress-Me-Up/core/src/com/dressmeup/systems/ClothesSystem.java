package com.dressmeup.systems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.entities.clothes.Hairs;
import com.dressmeup.entities.clothes.Skirts;
import com.dressmeup.game.DressMeUp;

public class ClothesSystem {
	
	private DressMeUp game;
	private HashMap<String, AbstractClothes> clothes;
	private List<String> iconKeys;
	private List<String> clotheKeys;
	
	public ClothesSystem(DressMeUp game) {
		this.game = game;	
				
		iconKeys = Arrays.asList(
				"Skirt_1",
				"Hair_1"
				);
		
		clotheKeys = Arrays.asList(
				"Skirt_1",
				"Hair_1",
				"Skirt_2",
				"Hair_2",
				"Hair_3"
				);
		
		Skirts skirt_1 = new Skirts(game);
		skirt_1.setIcon("Place_holders/Category_Icons/Skirt.png");
		skirt_1.setClothe("Place_holders/Category_Icons/Skirt.png");
		
		Skirts skirt_2 = new Skirts(game);
		skirt_2.setClothe("Place_holders/Category_Icons/Skirt.png");
		
		Hairs hair_1 = new Hairs(game);
		hair_1.setIcon("Place_holders/Category_Icons/Hair.png");
		hair_1.setClothe("Place_holders/Category_Icons/Hair.png");
		
		Hairs hair_2 = new Hairs(game);	
		hair_2.setClothe("Place_holders/Category_Icons/Hair.png");
		
		Hairs hair_3 = new Hairs(game);	
		hair_3.setClothe("Place_holders/Category_Icons/Hair.png");
		
		
		clothes = new HashMap<String, AbstractClothes>();
		clothes.put("Skirt_1", skirt_1);
		clothes.put("Hair_1", hair_1);		
		clothes.put("Skirt_2", skirt_2);
		clothes.put("Hair_2", hair_2);	
		clothes.put("Hair_3", hair_3);		
	}
	
	public AbstractClothes getClothe(String key) {
		return clothes.get(key);
	}
	
	public HashMap<String, AbstractClothes> getClothes() {
		return clothes;
	}

	public DressMeUp getGame() {
		return game;
	}

	public List<String> getIconKeys() {
		return iconKeys;
	}

	public List<String> getClotheKeys() {
		return clotheKeys;
	}
}
