package src.bomberdev.model;

import java.awt.Point;

import src.bomberdev.game.BomberViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class BomberLevel extends GameLevelDefaultImpl {

	BomberMap map;

	public BomberLevel(GameData data, BomberMap map) {
		super(data);
	}

	@Override
	protected void init() {
		this.universe = data.getUniverse();
		this.gameBoard = new BomberViewPort();
		this.gameBoard.setGameData(data);

		SolidBlock block = new SolidBlock(new Point(1, 1));
		this.universe.addGameEntity(block);
		this.universe.addGameEntity(block.draw(this.data.getCanvas()));
		
		
//		for (int j = 0; j < map.getNbRows(); j++) {
//			for (int i = 0; i < map.getNbColumns(); i++) {
//				this.universe.addGameEntity(map.getBrickAt(j, i));
//			}
//		}
//
//		for (int j = 0; j < map.getNbRows(); j++) {
//			for (int i = 0; i < map.getNbColumns(); i++) {
//				this.universe.addGameEntity(map.getBrickAt(j, i).drawable);
//			}
//		}

	}

}
