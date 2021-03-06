package no.ntnu.swa.a13;

import no.ntnu.swa.a13.landscape.LandscapeGenerator;
import no.ntnu.swa.a13.landscape.NetherlandsGenerator;
import no.ntnu.swa.a13.landscape.PolandGenerator;
import no.ntnu.swa.a13.landscape.CzechGenerator;
import no.ntnu.swa.a13.screens.*;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL10;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.Texture.TextureFilter;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends Game {
//	private OrthographicCamera camera;
//	private SpriteBatch batch;
//	private Texture texture;
//	private Sprite sprite;
	
	public static LandscapeGenerator getLandscapeGenerator() {
		double rand = Math.random();
		
		if(rand < 0.1d) {
			return new NetherlandsGenerator(); 
		} else if (rand < 0.5d) {
			return new PolandGenerator(); 
		} else {
			return new CzechGenerator(); 
		}
	}
	
	
//The different menus/ screens are made here, and created in create()
	public static MainMenuScreen mainMenuScreen;
	public static OptionsScreen optionsScreen;
	public static GameScreen gameScreen;
	public static GameOverScreen gameOverScreen;
	
//The lovely "global" variables will be made here, and created in create()
	//Scaling factor for box2d to make physics more plausible
	public static float b2dScale = 0.05f;
	public static Matrix4 scalingMatrix;
	
	//the Real width and height of the screen
	public static int wR;
	public static int hR;
	//Scaled dimensions for the camera
	public static float w;
	public static float h;
	

//A game needs players! -
	public static Player[] players;
//Late development turn monitoring variable
	public static int activePlayer = 0;
	
	
//Because it is easier to make and move code than the other way around
//it might look a bit nasty here for a while - Sindre
//At some point I will need to relinquish my love for global variables :(
	
	
	@Override
	public void create() {
		//the Real width and height of the screen
		wR = Gdx.graphics.getWidth();
		hR = Gdx.graphics.getHeight();
		
		//Scaling width and height
		w = wR*b2dScale;
		h = hR*b2dScale;
		//This matrix is needed to render smaller objects without losing details
		scalingMatrix = new Matrix4();
		scalingMatrix.setToScaling(b2dScale, b2dScale, 1);
		
		
		//Making players
		players = new Player[2];
		players[0] = new Player(1, new Vector2(0,0));
		players[1] = new Player(2, new Vector2(0,0));
		
		
	//Screens made after the other parts of the game have been created, this is important
	//because of the 'static' implementation, making the screens before the variables have
	//values sounds like a bad idea
		mainMenuScreen = new MainMenuScreen(this);
		optionsScreen = new OptionsScreen(this);
		gameScreen = new GameScreen(this, getLandscapeGenerator());
		gameOverScreen = new GameOverScreen(this);
		
	//The following call sets the initial screen, and it will start rendering
	//this is the last thing to happen in create()
		setScreen(mainMenuScreen);

	}

}
