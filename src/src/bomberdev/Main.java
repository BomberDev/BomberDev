package src.bomberdev;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameStatusBarElement;
import gameframework.gui.GameWindow;
import src.bomberdev.drawable.FactoryDrawable;
import src.bomberdev.game.BomberConfig;
import src.bomberdev.game.BomberLevel;
import src.bomberdev.model.BomberMap;
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
		GameConfiguration config = initialiseConfig();

		GameData gameData = new GameData(config);
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();


		// PLAYER
		src.bomberdev.model.motion.PlayerKeyboard keyboard = new src.bomberdev.model.motion.PlayerKeyboard();
		Character character = new Character(gameData.getUniverse(), keyboard);
		
		// STRATEGY

		BomberMap map = new BomberMap("BomberMap.txt", 13, 15);
		GameLevel level = new BomberLevel(gameData, map);
		gameData.addLevel(level);

		Game game = new GameDefaultImpl(gameData);

		GameCanvas canvas = gameData.getCanvas();
		canvas.addKeyListener(keyboard);

		// DRAWABLES
		FactoryDrawable.createDrawablesForAllEntities(gameData);
		
		GameWindow gameWindow = new GameWindow("BomberDev", canvas, config,
				new GameStatusBarElement<Integer>("score", score),
				new GameStatusBarElement<Integer>("life", life));

		gameWindow.createGUI();

		game.start();
		level.run();
	}
}
