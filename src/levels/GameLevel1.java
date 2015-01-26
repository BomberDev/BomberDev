package levels;

import java.util.Iterator;
import java.util.LinkedList;

import other.Methods;

import player.Player;

import entityConsole.BombUpConsole;
import entityConsole.Console;
import entityConsole.DestructibleBrickConsole;
import entityConsole.IndestructibleBrickConsole;
import entityConsole.MonsterConsole;
import entityConsole.LevelClearanceConsole;
import entityConsole.PowerUpConsole;
import entityConsole.SpeedUpConsole;
import entityConsole.models.BomberCharacter;
import entityConsole.models.Monster;
import update.GameUniverseViewPortImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.motion.MoveStrategyRandom;

public class GameLevel1 extends GameLevelDefaultImpl implements GameLevel {
	Player key;

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
		LevelClearanceConsole clear = new LevelClearanceConsole("/Blocks/Portal.png", 1, this);
		PowerUpConsole fp = new PowerUpConsole("/Powerups/FlamePowerup.png", 1);
		BombUpConsole bp = new BombUpConsole("/Powerups/BombPowerup.png", 1);
		SpeedUpConsole sp = new SpeedUpConsole("/Powerups/SpeedPowerup.png", 1);
		MonsterConsole monsters = new MonsterConsole("/Characters/ghost.png",8);
		explodableBlock.setGameData(data);
		solidBlock.setGameData(data);
		monsters.setGameData(data);
		clear.setGameData(data);
		fp.setGameData(data);
		bp.setGameData(data);
		sp.setGameData(data);
		fp.createEntity(1, 7);
		sp.createEntity(17, 7);
		sp.createEntity(9, 13);
		bp.createEntity(9, 1);
		clear.createEntity(9, 7);
		Methods.createMap(data, 0,
				"2222222222222222222\n" +
				"2000000000000000002\n" +
				"2021212120212121202\n" +
				"2011111110111111102\n" +
				"2021212120212121202\n" +
				"2011111110111111102\n" +
				"2021212120212121202\n" +
				"2000000000000000002\n" +
				"2021212120212121202\n" +
				"2011111110111111102\n" +
				"2021212120212121202\n" +
				"2011111110111111102\n" +
				"2021212120212121202\n" +
				"2000000000000000002\n" +
				"2222222222222222222"
				
				, explodableBlock, solidBlock);
		monsters.createEntity(10, 7);
		monsters.createEntity(9, 7);
		// set player
		universe.addGameEntity(key);
		key.setPosition(1, 1);
		key.setGameData(data);
		
		
	}

}
