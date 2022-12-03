package com.dressmeup.entities;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.dressmeup.entities.clothes.Eyes;
import com.dressmeup.entities.clothes.HairBack;
import com.dressmeup.entities.clothes.Dress;
import com.dressmeup.entities.clothes.EarRings;
import com.dressmeup.entities.clothes.HairFront;
import com.dressmeup.entities.clothes.Necklace;
import com.dressmeup.entities.clothes.Pants;
import com.dressmeup.entities.clothes.Shoes;
import com.dressmeup.entities.clothes.Skirts;
import com.dressmeup.entities.clothes.Tshirts;
import com.dressmeup.game.DressMeUp;

public class Mannequin{
	
	private DressMeUp game;
	private Eyes eyes = null;
	private Dress dress = null;
	private EarRings earRings = null;
	private HairFront hairFront = null;
	private HairBack hairBack = null;
	private Necklace necklace = null;
	private Pants pants = null;
	private Shoes shoes = null;
	private Skirts skirt = null;
	private Tshirts tshirt = null;
	private Texture mannequin, arm, mannequinTexture, armTexture;
	//private AbstractClothes clothes[]; 
	private HashMap<String, AbstractClothes> clothes;
	
	public Mannequin(DressMeUp game) {
		this.game = game;		
		mannequin = new Texture(Gdx.files.internal("Roupas/personagem_corpo.png"));		
		clothes = new HashMap<String, AbstractClothes>();
		
		mannequin.getTextureData().prepare();
		
		Pixmap scale = mannequin.getTextureData().consumePixmap();
		Pixmap pixmap = new Pixmap(750, 750, Format.RGBA8888);
		
		pixmap.drawPixmap(scale,
				0, 0, scale.getWidth(), scale.getHeight(),
				0, 0, 750, 750)	;			
			
		mannequinTexture = new Texture(pixmap);
		pixmap.dispose();
		scale.dispose();
		

		arm = new Texture(Gdx.files.internal("Roupas/personagem_braco.png"));
		
		arm.getTextureData().prepare();	
		
		Pixmap scale_ = arm.getTextureData().consumePixmap();
		Pixmap pixmap_ = new Pixmap(750, 750, Format.RGBA8888);
		
		pixmap_.drawPixmap(scale_,
				0, 0, scale_.getWidth(), scale_.getHeight(),
				0, 0, 750, 750)	;			
			
		armTexture = new Texture(pixmap_);
		pixmap_.dispose();
		scale_.dispose();
	}
	
	public void draw(Batch batch) {	
		batch.draw(mannequinTexture, 0, 0);
		for(String key : clothes.keySet()) {			
			if(clothes.get(key).isActive()) {
				batch.draw(clothes.get(key).getMannequinClothe(), 0, 0);
			}
		}
		batch.draw(armTexture, 0, 0);
	}
	
	public void setClotheInMannequin(AbstractClothes clothe) {
		switch (clothe.getNewClotheIndex()) {
		case Tshirts.NEW_CLOTHE_INDEX:
			setTshirt((Tshirts) clothe);
			break;
		case Skirts.NEW_CLOTHE_INDEX:
			setSkirt((Skirts) clothe);			
			break;
		case Necklace.NEW_CLOTHE_INDEX:
			setNecklace((Necklace) clothe);
			break;
		case EarRings.NEW_CLOTHE_INDEX:
			setEarRings((EarRings) clothe);
			break;
		case Pants.NEW_CLOTHE_INDEX:
			setPants((Pants) clothe);
			break;
		case Shoes.NEW_CLOTHE_INDEX:
			setShoes((Shoes) clothe);
			break;
		case Dress.NEW_CLOTHE_INDEX:
			setDress((Dress) clothe);
			break;
		case Eyes.NEW_CLOTHE_INDEX:
			setEyes((Eyes) clothe);
			break;
		case HairFront.NEW_CLOTHE_INDEX:
			setHairFront((HairFront) clothe);
			break;
		case HairBack.NEW_CLOTHE_INDEX:
			setHairBack((HairBack) clothe);
			break;
		default:
			return;
		}
		clothes.put(clothe.getRef(), clothe);
		
	}

	public Eyes getEyes() {
		return eyes;
	}

	public void setEyes(Eyes eyes) {
		this.eyes = eyes;
		clothes.put("eyes", eyes);
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

	public HairFront getHairFront() {
		return hairFront;
	}

	public void setHairFront(HairFront hair) {
		this.hairFront = hair;
	}
	
	public HairBack getHairBack() {
		return hairBack;
	}
	
	public void setHairBack(HairBack hairBack) {
		this.hairBack = hairBack;
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

	public Texture getMannequin() {
		return mannequin;
	}
	
	

}
