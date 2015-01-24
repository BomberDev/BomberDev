package main;

import entityConsole.models.BomberCharacter;
import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameStatusBarElement;
import gameframework.gui.GameWindow;
import gameframework.motion.MoveStrategyRandom;
import levels.GameLevel1;
import other.PlayerKeyboard;
import player.PlayerModel;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// INITIALIZATION

		GameConfiguration config = new GameConfiguration(15, 20, 40, 5);
		GameData gameData = new GameData(config);
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();

		GameLevel level = new GameLevel1(gameData);
		gameData.addLevel(level);

		
		// STRATEGIES

		PlayerKeyboard strategyKeyboard = new PlayerKeyboard();
		MoveStrategyRandom strategyRandom = new MoveStrategyRandom();

		// PLAYERS
		BomberCharacter player = null;
		PlayerModel random = null;
		try{
		player = new BomberCharacter(gameData, strategyRandom);
		player.initDrawable("/Characters/bomberman.png", gameData, 8);
		player.setPosition(1,1);
		

		random = new PlayerModel("/r1.png", gameData, 10, strategyRandom);
		random.setPoint(7,10);
		}catch(IllegalArgumentException e){
			System.out.println("Error:"+e.getLocalizedMessage()+"\n at Main.java an image can't be found");
			System.exit(0);
		}
		
		strategyKeyboard.setEntity(player);

		random.setPoint(50, 50);

		// ADD ENTITIES

		gameData.getUniverse().addGameEntity(player);
		gameData.getUniverse().addGameEntity(random);
		
		Game game = new GameDefaultImpl(gameData);
		/*
		 * GameUniverseViewPort universeViewPort = new
		 * GameUniverseViewPortDefaultImpl();
		 * universeViewPort.setGameData(gameData); universeViewPort.paint();
		 */
		GameCanvas canvas = gameData.getCanvas();

		canvas.addKeyListener(strategyKeyboard);
		
		GameWindow gameWindow = new GameWindow("BomberDev", canvas, config,new GameStatusBarElement<Integer>("score",score),new GameStatusBarElement<Integer>("life",life));

		gameWindow.createGUI();

		game.start();
		level.run();

	}
}