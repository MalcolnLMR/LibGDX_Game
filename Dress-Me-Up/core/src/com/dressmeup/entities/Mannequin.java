package com.dressmeup.entities;

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

public class Mannequin {
	
	private DressMeUp game;
	private Bracelet bracelet = null;
	private Dress dress = null;
	private EarRings earRings = null;
	private Hairs hair = null;
	private Necklace necklace = null;
	private Pants pants = null;
	private Shoes shoes = null;
	private Skirts skirt = null;
	private Tshirts tshirt = null;
	
	public Mannequin(DressMeUp game) {
		this.game = game;		
	}

	public Bracelet getBracelet() {
		return bracelet;
	}

	public void setBracelet(Bracelet bracelet) {
		this.bracelet = bracelet;
	}

	public Dress getDress() {
		return dress;
	}

	public void setDress(Dress dress) {
		this.dress = dress;
	}

	public EarRings getEarRings() {
		return earRings;
	}

	public void setEarRings(EarRings earRings) {
		this.earRings = earRings;
	}

	public Hairs getHair() {
		return hair;
	}

	public void setHair(Hairs hair) {
		this.hair = hair;
	}

	public Necklace getNecklace() {
		return necklace;
	}

	public void setNecklace(Necklace necklace) {
		this.necklace = necklace;
	}

	public Pants getPants() {
		return pants;
	}

	public void setPants(Pants pants) {
		this.pants = pants;
	}

	public Shoes getShoes() {
		return shoes;
	}

	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}

	public Skirts getSkirt() {
		return skirt;
	}

	public void setSkirt(Skirts skirt) {
		this.skirt = skirt;
	}

	public Tshirts getTshirt() {
		return tshirt;
	}

	public void setTshirt(Tshirts tshirt) {
		this.tshirt = tshirt;
	}

	public DressMeUp getGame() {
		return game;
	}
	
	

}
