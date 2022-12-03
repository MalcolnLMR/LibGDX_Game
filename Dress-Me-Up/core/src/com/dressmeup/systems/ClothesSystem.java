package com.dressmeup.systems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.entities.clothes.Dress;
import com.dressmeup.entities.clothes.EarRings;
import com.dressmeup.entities.clothes.Eyes;
import com.dressmeup.entities.clothes.HairBack;
import com.dressmeup.entities.clothes.HairFront;
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
		
		iconKeys = Arrays.asList("necklace_1", "skirt_1", "shirt_1", "earring_1", "pants_1", "shoes_1", "dress_1", "eyes_1", "hairfront_1", "hairback_1");

		clothes = new HashMap<String, AbstractClothes>();
		
		clothes.put("necklace_1", new Necklace(game, "Roupas/colar.png", "Roupas/menu_colar.png", "necklace_1"));
		clothes.put("necklace_2", new Necklace(game, "Roupas/colar2.png", "Roupas/menu_colar2.png", "necklace_2"));
		clothes.put("skirt_1", new Skirts(game, "Roupas/saia.png", "Roupas/saia.png", "skirt_1"));
		clothes.put("skirt_2", new Skirts(game, "Roupas/saia2.png", "Roupas/saia2.png", "skirt_2"));
		clothes.put("shirt_1", new Tshirts(game, "Roupas/camisa.png", "Roupas/menu_camisa.png", "shirt_1"));
		clothes.put("shirt_2", new Tshirts(game, "Roupas/camisa2.png", "Roupas/menu_camisa2.png", "shirt_2"));
		clothes.put("earring_1", new EarRings(game, "Roupas/brinco.png", "Roupas/menu_brinco.png", "earring_1"));
		clothes.put("earring_2", new EarRings(game, "Roupas/brinco2.png", "Roupas/menu_brinco2.png", "earring_2"));
		clothes.put("earring_3", new EarRings(game, "Roupas/brinco3.png", "Roupas/menu_brinco3.png", "earring_3"));	
		clothes.put("pants_1", new Pants(game, "Roupas/calca.png", "Roupas/menu_calca.png", "pants_1"));	
		clothes.put("pants_2", new Pants(game, "Roupas/calca2.png", "Roupas/menu_calca2.png", "pants_2"));	
		clothes.put("shoes_1", new Shoes(game, "Roupas/tenis.png", "Roupas/menu_tenis.png", "shoes_1"));	
		clothes.put("shoes_2", new Shoes(game, "Roupas/sapato.png", "Roupas/menu_sapato.png", "shoes_2"));	
		clothes.put("dress_1", new Dress(game, "Roupas/vestido.png", "Roupas/menu_vestido.png", "dress_1"));	
		clothes.put("dress_2", new Dress(game, "Roupas/vestido2.png", "Roupas/menu_vestido2.png", "dress_2"));	
		clothes.put("eyes_1", new Eyes(game, "Roupas/olhos.png", "Roupas/menu_olhos.png", "eyes_1"));	
		clothes.put("eyes_2", new Eyes(game, "Roupas/olhos2.png", "Roupas/menu_olhos2.png", "eyes_2"));	
		clothes.put("hairfront_1", new HairFront(game, "Roupas/cabelo_frente.png", "Roupas/menu_cabelo_frente.png", "hairFront_1"));	
		clothes.put("hairfront_2", new HairFront(game, "Roupas/cabelo_frente2.png", "Roupas/menu_cabelo_frente2.png", "hairFront_2"));	
		clothes.put("hairfront_3", new HairFront(game, "Roupas/cabelo_frente3.png", "Roupas/menu_cabelo_frente3.png", "hairFront_3"));	
		clothes.put("hairback_1", new HairBack(game, "Roupas/cabelo_atras.png", "Roupas/menu_cabelo_atras.png", "hairback_1"));	
		clothes.put("hairback_2", new HairBack(game, "Roupas/cabelo_atras2.png", "Roupas/menu_cabelo_atras2.png", "hairback_2"));
		clothes.put("hairback_3", new HairBack(game, "Roupas/cabelo_atras3.png", "Roupas/menu_cabelo_atras3.png", "hairback_3"));
		
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
