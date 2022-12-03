package com.dressmeup.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.dressmeup.game.DressMeUp;

// Classe base para criação de todos os tipos de roupas

public abstract class AbstractClothes {
	
	private Texture icon;
	private Texture clothe;
	private String iconPath;
	private String clothePath;	
	private Texture mannequinClothe = null;
	protected DressMeUp game;
	protected String ref;
	protected int newClotheIndex;
	private boolean active = false;	
	
	public AbstractClothes(DressMeUp game) {
		this.game = game;
		ref = "imgbtn_clothe";
	}
	
	public AbstractClothes(DressMeUp game, String clothePath, String iconPath, String ref, int clotheIndex) {
		newClotheIndex = clotheIndex;
		this.game = game;
		ref = "imgbtn_clothe";
	}
	
	public void setup() {
		setClotheBtnTexture();
		setScaledClothe();
	}
	
	public Texture getIcon() {
		return icon;
	}
	
	public void setClotheBtnTexture() {
		Texture splashTexture = new Texture(getIconPath()); // Remember to dispose
		splashTexture.getTextureData().prepare(); // The api-doc says this is needed
		
		Pixmap splashpixmap = splashTexture.getTextureData().consumePixmap(); // Strange name, but gives the pixmap of the texture. Remember to dispose this also
		Pixmap pixmap = new Pixmap(250, 250, Format.RGBA8888); // Remember to dispose		

		//ImageButtonStyle btnStyle = new ImageButtonStyle(game.getSkinManager().getSkin().get("imgbtn_clothe", ImageButtonStyle.class));
		ImageButtonStyle btnStyle = new ImageButtonStyle(); 
		//Texture splashTex = (Texture) btnStyle.up;
		Texture splashTex = game.getSkinManager().getSkin().get("imgui_btnbgup", Texture.class);
		splashTex.getTextureData().prepare();
		Pixmap splashPix = splashTex.getTextureData().consumePixmap();
		
		pixmap.drawPixmap(splashPix, 
				0, 0, splashPix.getWidth(), splashPix.getHeight(),
				0, 0, 250, 250);
		pixmap.drawPixmap(splashpixmap,
				0, 0, splashpixmap.getWidth(), splashpixmap.getHeight(),
				10, 10, 230, 230);
		
		btnStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
		
		pixmap.dispose();
		Pixmap pixmap_down = new Pixmap(250, 250, Format.RGBA8888);
		Texture splashTex_down = game.getSkinManager().getSkin().get("imgui_btnbgdown", Texture.class);
		splashTex_down.getTextureData().prepare();
		Pixmap splashPix_down = splashTex_down.getTextureData().consumePixmap();
		
		pixmap_down.drawPixmap(splashPix_down, 
				0, 0, splashPix_down.getWidth(), splashPix_down.getHeight(),
				0, 0, 250, 250);
		pixmap_down.drawPixmap(splashpixmap,
				0, 0, splashpixmap.getWidth(), splashpixmap.getHeight(),
				10, 10, 230, 230);
		
		btnStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap_down)));
		
		
		game.getSkinManager().getSkin().add(ref, btnStyle);
		
		// These are not needed anymore
		splashTex.dispose();
		splashPix.dispose();
		pixmap_down.dispose();
		splashpixmap.dispose();
		splashTexture.dispose();
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
	
	public void setScaledClothe() {
		Pixmap from = new Pixmap(Gdx.files.internal(getClothePath()));
		Pixmap to = new Pixmap(750, 750, from.getFormat());
		to.drawPixmap(from,
		        0, 0, from.getWidth(), from.getHeight(),
		        0, 0, to.getWidth(), to.getHeight()
		);
		mannequinClothe = new Texture(to);
		from.dispose();
		to.dispose();						
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
	
	public Texture getMannequinClothe() {
		return mannequinClothe;
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
	
	public String getIconPath() {
		return iconPath;
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
	
	public String getRef() {
		return ref;
	}
	
	public ClickListener getIconClickListener() {
		return new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				game.getGameStateSystem().getGame().setActualPage(getNewClotheIndex());
			}
		};
	}

	public ClickListener getClotheClickListener() {
		return new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				if(!isActive()) {
					for(String key : game.getClothesSystem().getClothes().keySet()) {
						if(game.getClothesSystem().getClothes().get(key).getClass().equals(getSelf().getClass())) 
							game.getClothesSystem().getClothes().get(key).setActive(false);						
					}
					setActive(true);
					game.getGameStateSystem().getGame().getMannequin().setClotheInMannequin(getSelf());
					return;
				} 
				setActive(false);
			}
		};
	}
	
	public abstract AbstractClothes getSelf();

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public int getNewClotheIndex() {
		return newClotheIndex;
	}
}
