package src.bomberdev;

import levels.GameLevel1;
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
import other.ActionKeyboard;
import player.Player;
import src.bomberdev.drawable.CharacterDrawable;
import src.bomberdev.game.BomberConfig;
import src.bomberdev.model.Character;
import decor.IndestructibleBrick;

public class Main {

	private static GameConfiguration initialiseConfig() {
		return new BomberConfig();
	}
	
	/*private static GameData initialiseData(GameConfiguration config) {
		
	} */
	
	public static void main(String[] args) {
		GameConfiguration config = initialiseConfig();
		
		GameData gameData = new GameData(config);
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();
		
		// STRATEGY
		MoveStrategyKeyboard strategyKeyboard = new MoveStrategyKeyboard(false);

		// PLAYER
		Character character = new Character(gameData.getUniverse());
		
		GameLevel level = new GameLevel1(gameData);
		gameData.addLevel(level);
		
		Game game = new GameDefaultImpl(gameData);
		
		GameCanvas canvas = gameData.getCanvas();
		canvas.addKeyListener(strategyKeyboard);
		
		// DRAWABLES
		character.setDrawable(new CharacterDrawable("/resources/Characters/bomberman.png", character, canvas));

		GameWindow gameWindow = new GameWindow(canvas, config,
				score, life);

		gameWindow.createGUI();

		game.start();
		level.run();
	}
}
