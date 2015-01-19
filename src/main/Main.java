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
import other.ActionKeyboard;
import player.Player;
import decor.IndestructibleBrick;

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

		MoveStrategyKeyboard strategyKeyboard = new MoveStrategyKeyboard(false);
		MoveStrategyRandom strategyRandom = new MoveStrategyRandom();

		// PLAYERS

		Player player = new Player("/resource/r1.png", gameData.getCanvas(),
				110, 10, strategyKeyboard);
		ActionKeyboard playerAction = new ActionKeyboard(player);

		Player random = new Player("/resource/r1.png", gameData.getCanvas(),
				110, 10, strategyRandom);

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
		canvas.addKeyListener(playerAction);

		GameWindow gameWindow = new GameWindow("BonberDev", canvas, config,
				score, life);

		gameWindow.createGUI();

		game.start();
		level.run();

	}
}
// entity createur
// cooldown controle
// flag controle
// AI controle
//