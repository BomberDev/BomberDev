package levels;

import entityConsole.DestructibleBrickConsole;
import entityConsole.IndestructibleBrickConsole;
import update.GameUniverseViewPortImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;

public class GameLevel1 extends GameLevelDefaultImpl implements GameLevel {

		public GameLevel1(GameData data) {
			super(data);
		}

		@Override
		protected void init(){
			this.universe=data.getUniverse();
			this.gameBoard= new GameUniverseViewPortImpl();
			gameBoard.setGameData(data);
			DestructibleBrickConsole explodableBlock = new DestructibleBrickConsole("/Blocks/ExplodableBlock.png", 1);
			IndestructibleBrickConsole solidBlock = new IndestructibleBrickConsole("/Blocks/SolidBlock.png", 1);
			explodableBlock.setGameData(data);
			solidBlock.setGameData(data);
			for(int i = 0;i<20;i++)	explodableBlock.createEntity(i,0);
			for(int i = 0;i<20;i++)	solidBlock.createEntity(i,14);
			for(int i = 1;i<14;i++)	explodableBlock.createEntity(0,i);
			for(int i = 1;i<14;i++)	solidBlock.createEntity(19,i);
		}

}
