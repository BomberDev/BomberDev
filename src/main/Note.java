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
import gameframework.motion.SpeedVector;
import levels.GameLevel1;
import other.ActionKeyboard;
import other.SpeedVectorChangingBySV;
import other.SpeedVectorControle;
import player.Player;

public class Note {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GameConfiguration config = new GameConfiguration();

		GameData gameData = new GameData(config);
		GameLevel level = new GameLevel1(gameData);
		gameData.addLevel(level);
		MoveStrategyKeyboard keyboard = new MoveStrategyKeyboard();
		SpeedVector usrSV = keyboard.getSpeedVector();
		usrSV.setSpeed(2);
		SpeedVector sv = new SpeedVectorChangingBySV(usrSV, 8);
		SpeedVectorControle csv = new SpeedVectorControle(
				(SpeedVectorChangingBySV) sv);
		sv.setSpeed(1);
		Player usrEntity = new Player("/resource/r1.png", gameData.getCanvas(),
				110, 10, sv);
		usrEntity.setPoint(15, 70);
		ActionKeyboard ab = new ActionKeyboard(usrEntity);
		gameData.getUniverse().addGameEntity(usrEntity);
		gameData.getUniverse().addGameEntity(csv);

		Game game = new GameDefaultImpl(gameData);
		/*
		 * GameUniverseViewPort universeViewPort = new
		 * GameUniverseViewPortDefaultImpl();
		 * universeViewPort.setGameData(gameData); universeViewPort.paint();
		 */
		GameCanvas canvas = gameData.getCanvas();

		canvas.addKeyListener(keyboard);
		canvas.addKeyListener(ab);
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();

		GameWindow gameWindow = new GameWindow(canvas, config, score, life);

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