package levels;

import java.util.Iterator;
import java.util.LinkedList;

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

public class GameLevel1 extends GameLevelDefaultImpl implements GameLevel {
	BomberCharacter key;
		public GameLevel1(GameData data,Player key) {
			super(data);
			this.key=key;
		}

		@Override
		protected void init(){
			//set game data
			this.universe=data.getUniverse();
			this.gameBoard= new GameUniverseViewPortImpl();
			gameBoard.setGameData(data);
			
			//clear last game level
			Iterator<GameEntity> it =universe.getGameEntitiesIterator();
			LinkedList<GameEntity> tmp = new LinkedList<GameEntity>();
			for(GameEntity entity;it.hasNext();){
				entity=it.next();
				if(entity instanceof Console) tmp.add(entity);
				else if(entity instanceof BomberCharacter) tmp.add(entity);
			}
			for(GameEntity entity:tmp){
				if(entity instanceof Console) ((Console<?, ?>)entity).setdown();
				else universe.removeGameEntity(entity);
			}
			
			
			//Creation
			DestructibleBrickConsole explodableBlock = new DestructibleBrickConsole("/Blocks/ExplodableBlock.png", 1);
			IndestructibleBrickConsole solidBlock = new IndestructibleBrickConsole("/Blocks/SolidBlock.png", 1);
			explodableBlock.setGameData(data);
			solidBlock.setGameData(data);
			for(int i = 0;i<20;i++)	explodableBlock.createEntity(i,0);
			for(int i = 0;i<20;i++)	solidBlock.createEntity(i,14);
			for(int i = 1;i<14;i++)	explodableBlock.createEntity(0,i);
			for(int i = 1;i<14;i++)	solidBlock.createEntity(19,i);
			
			//set player
			universe.addGameEntity(key);
			key.setPosition(1,1);
			key.setGameData(data);
		}

}