package src.bomberdev.game;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import src.bomberdev.model.BomberMap;
import src.bomberdev.model.Tile;

public class BomberLevel extends GameLevelDefaultImpl {

	BomberMap map;

	public BomberLevel(GameData data, BomberMap map) {
		super(data);
		this.map = map;
		init();
	}

	@Override
	protected void init() {
		
		this.universe = data.getUniverse();
		this.gameBoard = new BomberViewPort();
		this.gameBoard.setGameData(data);
		
		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				Tile tile = map.getTileAt(j, i);
				this.universe.addGameEntity(tile);
			}
		}
	}
}
