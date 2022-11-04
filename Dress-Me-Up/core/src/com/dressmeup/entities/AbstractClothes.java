package com.dressmeup.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

// Classe base para criação de todos os tipos de roupas

public abstract class AbstractClothes {
	
	private Texture icon;
	private Texture clothe;
	private String iconPath;
	private String clothePath;	
	
	public Texture getIcon() {
		return icon;
	}
	
	public Texture getScaledIcon(int size) {
		Pixmap pixmap200 = new Pixmap(Gdx.files.internal(iconPath));
		Pixmap pixmap100 = new Pixmap(size, size, pixmap200.getFormat());
		pixmap100.drawPixmap(pixmap200,
		        0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
		        0, 0, pixmap100.getWidth(), pixmap100.getHeight()
		);
		Texture texture = new Texture(pixmap100);
		pixmap200.dispose();
		pixmap100.dispose();		
		
		return texture;		
	}
	
	public Texture getScaledClothe(int size) {
		Pixmap pixmap200 = new Pixmap(Gdx.files.internal(clothePath));
		Pixmap pixmap100 = new Pixmap(size, size, pixmap200.getFormat());
		pixmap100.drawPixmap(pixmap200,
		        0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
		        0, 0, pixmap100.getWidth(), pixmap100.getHeight()
		);
		Texture texture = new Texture(pixmap100);
		pixmap200.dispose();
		pixmap100.dispose();		
		
		return texture;		
	}
	
	public void setIcon(String iconPath) {
		this.iconPath = iconPath;
		this.icon = new Texture(Gdx.files.internal(iconPath));
	}	

	public Texture getClothe() {
		return clothe;
	}

	public void setClothe(String clothe) {
		this.clothePath = clothe;
		this.clothe = new Texture(Gdx.files.internal(clothe));
	}		

	public String getClothePath() {
		return clothePath;
	}
	
	public Drawable getIconDrawable() {
		return new TextureRegionDrawable(new TextureRegion(getIcon()));
	}
	
	public Drawable getIconDrawable(int size) {
		return new TextureRegionDrawable(new TextureRegion(getScaledIcon(size)));
	}
	
	public Drawable getClotheDrawable() {
		return new TextureRegionDrawable(new TextureRegion(getClothe()));
	}
	
	public Drawable getClotheDrawable(int size) {
		return new TextureRegionDrawable(new TextureRegion(getScaledClothe(size)));
	}
	
	public abstract ClickListener getIconClickListener();

	public abstract ClickListener getClotheClickListener();



}
