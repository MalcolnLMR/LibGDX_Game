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
				"bracelet_1",
				"dress_1",
				"earRings_1",
				"hair_1",
				"necklace_1",
				"pants_1",
				"shoes_1",
				"skirt_1",
				"tshirt_1"
				);
		
		clotheKeys = Arrays.asList(
				"bracelet_1",
				"dress_1",
				"earRings_1",
				"hair_1",
				"necklace_1",
				"pants_1",
				"shoes_1",
				"skirt_1",
				"tshirt_1",
				"bracelet_2",
				"dress_2",
				"earRings_2",
				"hair_2",
				"necklace_2",
				"pants_2",
				"shoes_2",
				"skirt_2",
				"tshirt_2",
				"bracelet_3",
				"dress_3",
				"earRings_3",
				"hair_3",
				"necklace_3",
				"pants_3",
				"shoes_3",
				"skirt_3",
				"tshirt_3"
				);

		clothes = new HashMap<String, AbstractClothes>();
		
		Bracelet bracelet_1 = new Bracelet(game); 
		clothes.put("bracelet_1", bracelet_1);
		Bracelet bracelet_2 = new Bracelet(game); 
		clothes.put("bracelet_2", bracelet_2);
		Bracelet bracelet_3 = new Bracelet(game); 
		clothes.put("bracelet_3", bracelet_3);
				 
		Dress dress_1 = new Dress(game); clothes.put("dress_1", dress_1);
		Dress dress_2 = new Dress(game); clothes.put("dress_2", dress_2);
		Dress dress_3 = new Dress(game); clothes.put("dress_3", dress_3);
		
		EarRings earRings_1 = new EarRings(game); clothes.put("earRings_1", earRings_1); 
		EarRings earRings_2 = new EarRings(game); clothes.put("earRings_2", earRings_2);
		EarRings earRings_3 = new EarRings(game); clothes.put("earRings_3", earRings_3);
		
		Hairs hair_1 = new Hairs(game); clothes.put("hair_1", hair_1);
		Hairs hair_2 = new Hairs(game); clothes.put("hair_2", hair_2);			
		Hairs hair_3 = new Hairs(game);	clothes.put("hair_3", hair_3);
		
		Necklace necklace_1 = new Necklace(game); clothes.put("necklace_1", necklace_1);
		Necklace necklace_2 = new Necklace(game); clothes.put("necklace_2", necklace_2);
		Necklace necklace_3 = new Necklace(game); clothes.put("necklace_3", necklace_3);
		
		Pants pants_1 = new Pants(game); clothes.put("pants_1", pants_1);
		Pants pants_2 = new Pants(game); clothes.put("pants_2", pants_2);
		Pants pants_3 = new Pants(game); clothes.put("pants_3", pants_3);
		
		Shoes shoes_1 = new Shoes(game); clothes.put("shoes_1", shoes_1);
		Shoes shoes_2 = new Shoes(game); clothes.put("shoes_2", shoes_2);
		Shoes shoes_3 = new Shoes(game); clothes.put("shoes_3", shoes_3);	
		
		Skirts skirt_1 = new Skirts(game); clothes.put("skirt_1", skirt_1);
		Skirts skirt_2 = new Skirts(game); clothes.put("skirt_2", skirt_2);
		Skirts skirt_3 = new Skirts(game); clothes.put("skirt_3", skirt_3);
		
		Tshirts tshirts_1 = new Tshirts(game); clothes.put("tshirt_1", tshirts_1);
		Tshirts tshirts_2 = new Tshirts(game); clothes.put("tshirt_2", tshirts_2);
		Tshirts tshirts_3 = new Tshirts(game); clothes.put("tshirt_3", tshirts_3);			
			
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
