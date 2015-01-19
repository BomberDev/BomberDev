package gameLevels;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.MoveStrategyRandom;

import java.awt.Point;

import character.Player;

public class GameLevel1 extends GameLevelDefaultImpl implements GameLevel {

	public GameLevel1(GameData data) {
		super(data);
	}

	@Override
	protected void init() {
		MoveStrategyKeyboard keyboard = new MoveStrategyKeyboard();

		Player player = new Player("", keyboard, "/courbes.png",
				data.getCanvas(), 60, 2, new Point(50, 50));
		Player random = new Player("", new MoveStrategyRandom(),
				"/courbes.png", data.getCanvas(), 60, 2, new Point(50, 50));

		this.universe = data.getUniverse();
		this.gameBoard = new GameUniverseViewPortDefaultImpl();
		this.gameBoard.setGameData(data);
		this.data.getCanvas().addKeyListener(keyboard);
		this.universe.addGameEntity(player);
		this.universe.addGameEntity(random);

	}
}
