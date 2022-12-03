package com.dressmeup.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.dressmeup.game.DressMeUp;

public class SkinsManager {
	
	private DressMeUp game;
	private Skin skin;
	private ImageButtonStyle clotheButton;
	private TextButtonStyle menuButton;
	private ImageButtonStyle iconClotheButton;
	private TextButtonStyle dialogButtonPlayer, dialogButtonCustomer;
	private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
							  + "abcdefghijklmnopqrstuvwxyz"
							  + "¡¢£¤¥¦§¨©ª«¬­"
							  + "®¯°±²³´µ¶∙¸¹º"
							  + "»¼½¾¿ÀÁÂÃÄÅÆÇ"
							  + "ÈÉÊËÌÍÎÏÐÑÒÓÔ"
							  + "ÕÖ×ØÙÚÛÜÝÞßàá"
							  + "âãäåæçèéêëìíî"
							  + "ïðñòóôõö÷øùúû"
							  + "üýþÿ"
							  + ".,:;_¡!¿?\\\"'+-*/()[]={}";
	
	
	public SkinsManager(DressMeUp game) {
		
		this.game = game;
		
		skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));		
		//generateButton();
		loadButtons();
		loadImages();
	}
	
	private void loadButtons() {
		FreeTypeFontGenerator generator_menu = new FreeTypeFontGenerator(Gdx.files.internal("text/josephsophia.ttf"));
		FreeTypeFontParameter parameters_menu = new FreeTypeFontParameter();
		parameters_menu.size = 25;
		parameters_menu.color = Color.BLACK;
		//parameters_menu.characters = characters;		
		
		FreeTypeFontGenerator generator_dialog = new FreeTypeFontGenerator(Gdx.files.internal("text/OpenSans-Light.ttf"));
		FreeTypeFontParameter parameters_dialog = new FreeTypeFontParameter();		
		parameters_dialog.size = 20;
		parameters_dialog.color = Color.BLACK;
		parameters_dialog.characters = characters;
		
		clotheButton = new ImageButtonStyle();
		clotheButton.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Icon_cloth_deselect.png"))));
		clotheButton.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Icon_cloth_select.png"))));
		skin.add("imgbtn_clothe", clotheButton);
		
		menuButton = new TextButtonStyle();
		menuButton.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_normal.png"))));
		menuButton.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_apertado.png"))));		
		menuButton.font = generator_menu.generateFont(parameters_menu);	
		skin.add("txtbtn_menu", menuButton);
		
		iconClotheButton = new ImageButtonStyle();
		iconClotheButton.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botao_redondo_atelie_normal.png"))));
		iconClotheButton.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botao_redondo_atelie_apertado.png"))));
		skin.add("imgbtn_icon", iconClotheButton);			

		dialogButtonPlayer = new TextButtonStyle();
		dialogButtonPlayer.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_normal.png"))));
		dialogButtonPlayer.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_normal.png"))));
		dialogButtonPlayer.font = generator_dialog.generateFont(parameters_dialog);	
		skin.add("txtbtn_dialogP", dialogButtonPlayer);
		
		dialogButtonCustomer = new TextButtonStyle();
		dialogButtonCustomer.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_apertado.png"))));
		dialogButtonCustomer.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_apertado.png"))));
		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("text/josephsophia.ttf"));
		dialogButtonCustomer.font = generator_dialog.generateFont(parameters_dialog);
		skin.add("txtbtn_dialogC", dialogButtonCustomer);
		

		generator_dialog.dispose();
		generator_menu.dispose();
	}
	
	private void loadImages() {
		skin.add("imgui_pause", new Texture(Gdx.files.internal("FABULOSO_ATELIE_JANELA_PAUSE.png")));
		skin.add("imgui_btnbgup", new Texture(Gdx.files.internal("Icon_cloth_deselect.png")));
		skin.add("imgui_btnbgdown", new Texture(Gdx.files.internal("Icon_cloth_select.png")));
	}
	
	public ImageButtonStyle getClotheButton() {
		return clotheButton;
	}

	public Skin getSkin() {
		return skin;
	}

	public DressMeUp getGame() {
		return game;
	}

}
