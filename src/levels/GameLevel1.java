package levels;

import java.util.Iterator;
import java.util.LinkedList;

import player.Player;

import entityConsole.BombUpConsole;
import entityConsole.Console;
import entityConsole.DestructibleBrickConsole;
import entityConsole.IndestructibleBrickConsole;
import entityConsole.PowerUpConsole;
import entityConsole.SpeedUpConsole;
import entityConsole.models.BomberCharacter;
import update.GameUniverseViewPortImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;

public class GameLevel1 extends GameLevelDefaultImpl implements GameLevel {
	BomberCharacter key;

	public GameLevel1(GameData data, Player key) {
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
		PowerUpConsole fp = new PowerUpConsole("/Powerups/FlamePowerup.png", 1);
		BombUpConsole bp = new BombUpConsole("/Powerups/BombPowerup.png", 1);
		SpeedUpConsole sp = new SpeedUpConsole("/Powerups/SpeedPowerup.png", 1);
		explodableBlock.setGameData(data);
		solidBlock.setGameData(data);
		fp.setGameData(data);
		bp.setGameData(data);
		sp.setGameData(data);
		fp.createEntity(1, 7);
		sp.createEntity(17, 7);
		sp.createEntity(9, 13);
		bp.createEntity(9, 1);
		for (int i = 0; i < 19; i++)
			solidBlock.createEntity(i, 0);
		for (int i = 0; i < 19; i++)
			solidBlock.createEntity(i, 14);
		for (int i = 1; i < 14; i++)
			solidBlock.createEntity(0, i);
		for (int i = 1; i < 14; i++)
			solidBlock.createEntity(18, i);

		for (int j = 2; j < 9; j++)
			for (int i = 2; i < 7; i++)
				explodableBlock.createEntity(j, i);

		for (int j = 10; j < 17; j++)
			for (int i = 2; i < 7; i++)
				explodableBlock.createEntity(j, i);

		for (int j = 2; j < 9; j++)
			for (int i = 8; i < 13; i++)
				explodableBlock.createEntity(j, i);

		for (int j = 10; j < 17; j++)
			for (int i = 8; i < 13; i++)
				explodableBlock.createEntity(j, i);

		for (int j = 2; j < 18; j += 2)
			for (int i = 2; i < 14; i += 2)
				solidBlock.createEntity(j, i);

		// set player
		universe.addGameEntity(key);
		key.setPosition(1, 1);
		key.setGameData(data);
	}

}
