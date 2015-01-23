package levels;

import src.bomberdev.game.BomberViewPort;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevel;
import gameframework.game.GameLevelDefaultImpl;

public class GameLevel1 extends GameLevelDefaultImpl implements GameLevel {

		public GameLevel1(GameData data) {
			super(data);
		}


		protected void init(){
			this.universe = data.getUniverse();
			this.gameBoard = new BomberViewPort();//TODO
			this.gameBoard.setGameData(data);
		}

}
