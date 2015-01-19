package main;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameWindow;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.MoveStrategyRandom;
import levels.GameLevel1;
import other.PlayerKeyboard;
import player.Player;
import models.IndestructibleBrick;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// INITIALIZATION

		GameConfiguration config = new GameConfiguration(30, 60, 16, 5);
		GameData gameData = new GameData(config);
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();

		GameLevel level = new GameLevel1(gameData);
		gameData.addLevel(level);

		
		// STRATEGIES

		PlayerKeyboard strategyKeyboard = new PlayerKeyboard();
		MoveStrategyRandom strategyRandom = new MoveStrategyRandom();

		// PLAYERS
		Player player = null;
		Player random = null;
		try{
		player = new Player("/resource/bomberman.png", gameData.getCanvas(),
				110, 8, strategyKeyboard);
		

		random = new Player("/resource/r1.png", gameData.getCanvas(),
				110, 10, strategyRandom);
		}catch(IllegalArgumentException e){
			System.out.println("Error:"+e.getLocalizedMessage()+"\n at Main.java an image can't be found");
			System.exit(0);
		}
		
		strategyKeyboard.setEntity(player);

		random.setPoint(50, 50);

		// ADD ENTITIES

		gameData.getUniverse().addGameEntity(player);
		gameData.getUniverse().addGameEntity(random);
		gameData.getUniverse().addGameEntity(new IndestructibleBrick());

		Game game = new GameDefaultImpl(gameData);
		/*
		 * GameUniverseViewPort universeViewPort = new
		 * GameUniverseViewPortDefaultImpl();
		 * universeViewPort.setGameData(gameData); universeViewPort.paint();
		 */
		GameCanvas canvas = gameData.getCanvas();

		canvas.addKeyListener(strategyKeyboard);
		
		GameWindow gameWindow = new GameWindow("BonberDev", canvas, config,
				score, life);

		gameWindow.createGUI();

		game.start();
		level.run();

	}
}