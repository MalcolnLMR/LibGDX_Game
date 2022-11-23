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
	
	
	public SkinsManager(DressMeUp game) {
		
		this.game = game;
		
		skin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));		
		//generateButton();
		loadButtons();
		loadImages();
	}
	
	private void loadButtons() {
		clotheButton = new ImageButtonStyle();
		clotheButton.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Icon_cloth_deselect.png"))));
		clotheButton.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Icon_cloth_select.png"))));
		skin.add("imgbtn_clothe", clotheButton);
		
		menuButton = new TextButtonStyle();
		menuButton.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_normal.png"))));
		menuButton.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botoes_atelie_apertado.png"))));
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("PlayfairDisplay-Regular.ttf"));
		FreeTypeFontParameter parameters = new FreeTypeFontParameter();
		parameters.size = 20;
		parameters.color = Color.BLACK;
		menuButton.font = generator.generateFont(parameters);
		generator.dispose();		
		skin.add("txtbtn_menu", menuButton);
		
		iconClotheButton = new ImageButtonStyle();
		iconClotheButton.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botao_redondo_atelie_normal.png"))));
		iconClotheButton.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("botao_redondo_atelie_apertado.png"))));
		skin.add("imgbtn_icon", iconClotheButton);			
		
	}
	
	private void loadImages() {
		skin.add("imgui_pause", new Texture(Gdx.files.internal("FABULOSO_ATELIE_JANELA_PAUSE.png")));
	}
	
//	private void generateButton() {
//		
//		// Generate a 1x1 white texture and store it in the skin named "white".
//		Pixmap pixmap = new Pixmap(100, 100, Format.RGBA8888);
//		pixmap.setColor(Color.WHITE);
//		pixmap.fill();
//		skin.add("white", new Texture(pixmap));
//
//		// Store the default libGDX font under the name "default".
//		skin.add("default", new BitmapFont());
//		
//		//this.skin = new Skin(Gdx.files.internal("skin" + File.separator + "clean-crispy-ui.json"));
//		ButtonStyle buttonStyle = new ButtonStyle();
//		buttonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
//		buttonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
//		buttonStyle.checked = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
//		buttonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
//		skin.add("btn_default", buttonStyle);
//	}
	
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
