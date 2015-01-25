package src.bomberdev.game;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

import java.io.File;

import src.bomberdev.model.Block;
import src.bomberdev.model.BomberMap;

public class BomberLevel extends GameLevelDefaultImpl {

	protected static final String PACKAGE_NAME = "target/classes/Resources/Maps/";

	protected BomberMap map;
	protected File actualLevel;

	public BomberLevel(GameData data) {
		super(data);
		this.actualLevel = new File(getMapsFiles(PACKAGE_NAME)[0]);
		this.map = new BomberMap(actualLevel.getName(), 9, 17);
	}

	public String[] getMapsFiles(String path) {
		File folder = new File(path);
		return folder.list();
	}

	@Override
	protected void init() {

		this.universe = data.getUniverse();
		this.gameBoard = new BomberViewPort();
		this.gameBoard.setGameData(data);

		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				Block block = map.getBrickAt(j, i);

				if (block != null) {
					this.universe.addGameEntity(block);
				}
			}
		}

		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				Block block = map.getBrickAt(j, i);

				if (block != null) {
					this.universe.addGameEntity(block.draw(this.data
							.getCanvas()));
				}
			}
		}

	}

}
