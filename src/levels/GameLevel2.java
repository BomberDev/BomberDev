package levels;

import java.util.Iterator;
import java.util.LinkedList;

import other.Methods;

import player.Player;

import entityConsole.Console;
import entityConsole.DestructibleBrickConsole;
import entityConsole.IndestructibleBrickConsole;
import entityConsole.models.BomberCharacter;
import update.GameUniverseViewPortImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;

public class GameLevel2 extends GameLevelDefaultImpl implements GameLevel {
	Player key;

	public GameLevel2(GameData data, Player key) {
		super(data, 70);
		this.key = key;
	}

	@Override
	protected void init() {
		// set game data
		this.universe = data.getUniverse();
		this.gameBoard = new GameUniverseViewPortImpl();
		gameBoard.setGameData(data);

		// clear last game level
		Iterator<GameEntity> it = universe.getGameEntitiesIterator();
		LinkedList<GameEntity> tmp = new LinkedList<GameEntity>();
		for (GameEntity entity; it.hasNext();) {
			entity = it.next();
			if (entity instanceof Console)
				tmp.add(entity);
			else if (entity instanceof BomberCharacter)
				tmp.add(entity);
		}
		for (GameEntity entity : tmp) {
			if (entity instanceof Console)
				((Console<?, ?>) entity).setdown();
			else
				universe.removeGameEntity(entity);
		}

		// Creation
		DestructibleBrickConsole explodableBlock = new DestructibleBrickConsole(
				"/Blocks/ExplodableBlock.png", 1);
		IndestructibleBrickConsole solidBlock = new IndestructibleBrickConsole(
				"/Blocks/SolidBlock.png", 1);
		
		explodableBlock.setGameData(data);
		solidBlock.setGameData(data);
		Methods.createMap(data, 0,
				"2 2 2 2 2 2 2 2 2 2 2 2 2 2 2\n" +
				"2 0 0 1 1 0 1 1 1 0 1 1 0 0 2\n" +
				"2 0 2 1 2 1 2 1 2 1 2 1 2 0 2\n" +
				"2 1 1 1 0 0 1 0 1 0 0 1 1 1 2\n" +
				"2 1 2 1 2 0 2 1 2 0 2 1 2 1 2\n" +
				"2 1 1 0 1 1 1 0 1 1 1 0 1 1 2\n" +
				"2 0 2 1 2 1 2 1 2 1 2 1 2 0 2\n" +
				"2 1 1 0 1 1 1 0 1 1 1 0 1 1 2\n" +
				"2 1 2 1 2 0 2 1 2 0 2 1 2 1 2\n" +
				"2 1 1 1 0 0 1 0 1 0 0 1 1 1 2\n" +
				"2 0 2 1 2 1 2 1 2 1 2 1 2 0 2\n" +
				"2 0 0 1 1 0 1 1 1 0 1 1 0 0 2\n" +
				"2 2 2 2 2 2 2 2 2 2 2 2 2 2 2"

				, explodableBlock, solidBlock);

		// set player
		universe.addGameEntity(key);
		key.setPosition(1, 1);
		key.setGameData(data);
	}

}
