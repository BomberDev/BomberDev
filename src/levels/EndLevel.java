package levels;

import java.util.Iterator;
import java.util.LinkedList;

import other.Methods;

import entityConsole.Console;
import entityConsole.DestructibleBrickConsole;
import entityConsole.IndestructibleBrickConsole;
import entityConsole.models.BomberCharacter;
import update.GameUniverseViewPortImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;

public class EndLevel extends GameLevelDefaultImpl implements GameLevel {
	public EndLevel(GameData data) {
		super(data, 70);
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
				"2222222222222222222\n" +
				"0000000000000000000\n" +
				"0111122221001222200\n" +
				"0100020021111200000\n" +
				"0101122221001222200\n" +
				"0100120021001200000\n" +
				"0111120021001222200\n" +
				"0000000000000000000\n" +
				"0222210012222111100\n" +
				"0200210012000100100\n" +
				"0200210012222111100\n" +
				"0200210012000101000\n" +
				"0222201102222100100\n" +
				"0000000000000000000\n" +
				"2222222222222222222\n"
				, explodableBlock, solidBlock);
		
	}

}
