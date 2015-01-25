package src.bomberdev;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameWindow;
import gameframework.motion.MoveStrategyKeyboard;
import src.bomberdev.drawable.CharacterDrawable;
import src.bomberdev.game.BomberConfig;
import src.bomberdev.game.BomberLevel;
import src.bomberdev.model.Character;

public class Main {

	private static GameConfiguration initialiseConfig() {
		return new BomberConfig();
	}

	/*
	 * private static GameData initialiseData(GameConfiguration config) {
	 * 
	 * }
	 */

	public static void main(String[] args) {

		// GAME CONFIGURATION

		GameConfiguration config = initialiseConfig();

		GameData gameData = new GameData(config);
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();

		GameLevel level = new BomberLevel(gameData);
		gameData.addLevel(level);

		Game game = new GameDefaultImpl(gameData);

		GameCanvas canvas = gameData.getCanvas();

		// STRATEGY
		MoveStrategyKeyboard strategyKeyboard = new MoveStrategyKeyboard(false);
		canvas.addKeyListener(strategyKeyboard);

		// PLAYER
		Character character = new Character(gameData.getUniverse());

		// DRAWABLES
		character.setDrawable(new CharacterDrawable(
				"/Resources/Graphics/Characters/bomberman.png", character,
				canvas));

		GameWindow gameWindow = new GameWindow(canvas, config, score, life);

		gameWindow.createGUI();

		game.start();
		level.run();
	}
}
