package com.dressmeup.systems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.entities.clothes.Bracelet;
import com.dressmeup.entities.clothes.Dress;
import com.dressmeup.entities.clothes.EarRings;
import com.dressmeup.entities.clothes.Hairs;
import com.dressmeup.entities.clothes.Necklace;
import com.dressmeup.entities.clothes.Pants;
import com.dressmeup.entities.clothes.Shoes;
import com.dressmeup.entities.clothes.Skirts;
import com.dressmeup.entities.clothes.Tshirts;
import com.dressmeup.game.DressMeUp;

public class ClothesSystem {
	
	private DressMeUp game;
	private HashMap<String, AbstractClothes> clothes;
	private List<String> iconKeys;
	private List<String> clotheKeys;
	
	public ClothesSystem(DressMeUp game) {
		this.game = game;	
				
		iconKeys = Arrays.asList(
				"necklace_1",
				"skirt_1"
				);
		
		clotheKeys = Arrays.asList(
				"necklace_1",
				"skirt_1",
				"skirt_2"
				);

		clothes = new HashMap<String, AbstractClothes>();
		
		Necklace necklace_1 = new Necklace(game); clothes.put("necklace_1", necklace_1);
		
		Skirts skirt_1 = new Skirts(game); clothes.put("skirt_1", skirt_1);
		Skirts skirt_2 = new Skirts(game); clothes.put("skirt_2", skirt_2);	
			
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
