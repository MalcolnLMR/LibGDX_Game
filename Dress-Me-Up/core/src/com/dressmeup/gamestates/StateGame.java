package com.dressmeup.gamestates;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
		setupDialogBox();
		setupStage();
	}	
	
	public void setupStage() {
		stage.clear();
		
		Table clothesOrigin = new Table();
		
		//clothesOrigin.setY(GameConfigs.getScaledHeight() - CATEGORY_BUTTON_SIZE/2);
		clothesOrigin.setY(0);
		clothesOrigin.setX((float) (GameConfigs.getScaledWidth() * 0.3));
		clothesOrigin.setWidth((float) (GameConfigs.getScaledWidth() * 0.7));
		clothesOrigin.setHeight(GameConfigs.getScaledHeight());
		clothesOrigin.top().left();		
		
		// Making Icons
		
		Table categoryIcons = new Table();		
		categoryIcons.left();
		
		for(String key : game.getClothesSystem().getIconKeys()) {
			categoryIcons.add(new IconButton(game.getClothesSystem().getClothe(key), CATEGORY_BUTTON_SIZE))
			.padRight(CATEGORY_BUTTON_PADDING)
			.left();
		}		
		
		clothesOrigin.add(categoryIcons).left();
		clothesOrigin.row();	
		
		// Making clickable clothes
		
		clickableClothes = new Table();
				
		for(String key : game.getClothesSystem().getClotheKeys()) {
			ClotheButton button = new ClotheButton(game.getClothesSystem().getClothe(key), CLOTHE_BUTTON_SIZE);
			if(button.getClothe().getClass().equals(clothes.get(actualPage)) ) {
				clickableClothes.add(button)
				.padRight(CLOTHE_BUTTON_PADDING)
				.left();				
			}
		}
		
		clothesOrigin.add(clickableClothes).padTop(50);
		
		clothesOrigin.setDebug(DEBUG);
		categoryIcons.setDebug(DEBUG);
		clickableClothes.setDebug(DEBUG);
		
		
		stage.addActor(clothesOrigin);
		stage.addActor(dialogBox);
	}
	
	public void setupDialogBox() {
		
		dialogBox = new DialogButton(game.getSkinManager().getSkin(), actualCustomer);
		dialogBox.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				nextDialog();
			}
		});
		
		stage.addActor(dialogBox);
		
	}
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(stage);		
	}

	@Override
	public void render() {
		stage.draw();
	}
	
	@Override
	public void tick() {	
		stage.act();
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
		setupStage();
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
	
	

}
