package com.dressmeup.gamestates;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.dressmeup.configs.GameConfigs;
import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.entities.AbstractCustomers;
import com.dressmeup.entities.clothes.Bracelet;
import com.dressmeup.entities.clothes.Dress;
import com.dressmeup.entities.clothes.EarRings;
import com.dressmeup.entities.clothes.Hairs;
import com.dressmeup.entities.clothes.Necklace;
import com.dressmeup.entities.clothes.Pants;
import com.dressmeup.entities.clothes.Shoes;
import com.dressmeup.entities.clothes.Skirts;
import com.dressmeup.entities.clothes.Tshirts;
import com.dressmeup.enums.GameStates;
import com.dressmeup.game.DressMeUp;
import com.dressmeup.utils.ClotheButton;
import com.dressmeup.utils.DialogButton;
import com.dressmeup.utils.IconButton;

public class StateGame extends AbstractGameState {
	
	private static final int CATEGORY_BUTTON_SIZE = 100;
	private static final int CLOTHE_BUTTON_SIZE = 250;
	private static final int CATEGORY_BUTTON_PADDING = 5;
	private static final int CLOTHE_BUTTON_PADDING = 5;
	private final boolean DEBUG = false;
	private List<Class<? extends AbstractClothes>> clothes;
	private int actualPage = 0;
	private int actualDialog = 0;
	private AbstractCustomers actualCustomer;
	private Stage stage;
	private Boolean active;	
	private DressMeUp game;
	private Table clickableClothes;
	private DialogButton dialogBox;
	private ImageButton clientButton, clothesButton;
	private Texture background;
	private Drawable backgroundTable;
	
	public StateGame(DressMeUp game) {		
		this.game = game;
		stage = new Stage();	
		clothes = Arrays.asList(
				Bracelet.class,
				Dress.class,
				EarRings.class,
				Hairs.class,
				Necklace.class,
				Pants.class,
				Shoes.class,
				Skirts.class,
				Tshirts.class
				);
		actualCustomer = game.getCustomerSystem().getRaquel();
		background = new Texture(Gdx.files.internal("cenario_externo_fabuloso_atelie-01.png"));
		backgroundTable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("tela_preta_semitransparente.png"))));
		setupDialogBox();
		setupButtonChange();
		setupClothesStage();		
	}	
	
	public void setupClothesStage() {
		stage.clear();
		
		Table clothesOrigin = new Table();
		
		//clothesOrigin.setY(GameConfigs.getScaledHeight() - CATEGORY_BUTTON_SIZE/2);
		clothesOrigin.setY(0);
		clothesOrigin.setX((float) (GameConfigs.getScaledWidth() * 0.3));
		clothesOrigin.setWidth((float) (GameConfigs.getScaledWidth() * 0.7));
		clothesOrigin.setHeight(GameConfigs.getScaledHeight());
		clothesOrigin.center().top();
		
		// Making Icons
		
		Table categoryIcons = new Table();		
		categoryIcons.left();
		
		for(String key : game.getClothesSystem().getIconKeys()) {
			categoryIcons.add(new IconButton(game.getClothesSystem().getClothe(key), CATEGORY_BUTTON_SIZE, game))
			.padRight(CATEGORY_BUTTON_PADDING)
			.left()
			.size(CATEGORY_BUTTON_SIZE);
		}
		clothesOrigin.add(categoryIcons);
		clothesOrigin.row();	
		
		// Making clickable clothes
		
		clickableClothes = new Table();
				
		for(String key : game.getClothesSystem().getClotheKeys()) {
			ClotheButton button = new ClotheButton(game.getClothesSystem().getClothe(key), CLOTHE_BUTTON_SIZE, game);
			if(button.getClothe().getClass().equals(clothes.get(actualPage)) ) {
				clickableClothes.add(button)
				.padRight(CLOTHE_BUTTON_PADDING)
				.left()
				.size(CLOTHE_BUTTON_SIZE);				
			}
		}
		clothesOrigin.add(clickableClothes).padTop(50);
		
		clothesOrigin.setBackground(backgroundTable);
		clothesOrigin.setColor(0, 0, 0, (float) 1);
		clickableClothes.setColor(0, 0, 0, 1);
		
		clothesOrigin.setDebug(DEBUG);
		categoryIcons.setDebug(DEBUG);
		clickableClothes.setDebug(DEBUG);
		
		
		stage.addActor(clothesOrigin);
		stage.addActor(clientButton);
	}
	
	public void setupClientStage() {
		stage.clear();
		stage.addActor(dialogBox);
		stage.addActor(clothesButton);
	}
	
	public void setupDialogBox() {		
		dialogBox = new DialogButton(game.getSkinManager().getSkin(), actualCustomer);
		dialogBox.addListener(new ClickListener(Buttons.LEFT) {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				nextDialog();
			}
		});
		dialogBox.addListener(new ClickListener(Buttons.RIGHT) {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);				
				previousDialog();
			}
		});
		
		stage.addActor(dialogBox);
		
	}
	
	public void setupButtonChange() {
		clientButton = new ImageButton(game.getSkinManager().getSkin(), "imgbtn_clothe");
		clientButton.setPosition(10, 50);
		clientButton.setSize(50, 50);
		clientButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				setupClientStage();
			}
		});
		clothesButton = new ImageButton(game.getSkinManager().getSkin(), "imgbtn_clothe");
		clothesButton.setPosition(GameConfigs.getScaledWidth() - 110, 50);
		clothesButton.setSize(50, 50);
		clothesButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				setupClothesStage();
			}
		});
	}
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(stage);		
	}

	@Override
	public void render() {
		stage.getBatch().begin();
		stage.getBatch().draw(background, 0, 0, GameConfigs.getScaledWidth(), GameConfigs.getScaledHeight());
		stage.getBatch().end();
		
		stage.draw();
	}
	
	@Override
	public void tick() {	
		stage.act();
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			game.getGameStateSystem().setActualState(GameStates.PAUSE);
		}
	}
	
	@Override
	public void dispose() {
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
		setupClothesStage();
	}

	public Table getClickableClothes() {
		return clickableClothes;
	}

	public void setClickableClothes(Table clickableClothes) {
		this.clickableClothes = clickableClothes;
	}

	public int getActualDialog() {
		return actualDialog;
	}

	public void nextDialog() {
		if(actualDialog < actualCustomer.getMaxDialogs() - 1) {
			this.actualDialog++;
			dialogBox.setActualDialog(actualDialog);
		}
	}
	
	public void previousDialog() {
		if(actualDialog > 0) {
			this.actualDialog--;
			dialogBox.setActualDialog(actualDialog);
		}
	}
	
	

}
