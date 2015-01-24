package src.bomberdev.game;

import java.awt.Point;

import src.bomberdev.model.Block;
import src.bomberdev.model.BomberMap;
import src.bomberdev.model.SolidBlock;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class BomberLevel extends GameLevelDefaultImpl {

	BomberMap map;

	public BomberLevel(GameData data, BomberMap map) {
		super(data);
		this.universe = data.getUniverse();
		this.gameBoard = new BomberViewPort();
		this.gameBoard.setGameData(data);
		this.map = map;
	}

	@Override
	protected void init() {

		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				Block block = map.getBrickAt(j, i);
				
				if(block != null) {	
					this.universe.addGameEntity(block);
				}
			}
		}

		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				Block block = map.getBrickAt(j, i);
				
				if(block != null) {				
					this.universe.addGameEntity(block.draw(this.data.getCanvas()));
				}
			}
		}

	}

}
