package src.bomberdev.game;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

import java.io.File;
import java.util.Arrays;

import src.bomberdev.LevelFinder;
import src.bomberdev.model.Block;
import src.bomberdev.model.BomberMap;

public class BomberLevel extends GameLevelDefaultImpl {

	protected static final String PACKAGE_NAME = "target/classes/Resources/Maps/";

	protected BomberMap map;
	protected File actualLevel;
	protected LevelFinder finder = new LevelFinder(new File(
			"target/classes/Resources/Maps"));

	public BomberLevel(GameData data, int rows, int columns) {
		super(data);
		this.actualLevel = getMapsFiles()[0];
		this.map = new BomberMap(actualLevel.getName(), rows, columns);
	}

	public File[] getMapsFiles() {
		File[] levels = finder.levelFile();
		Arrays.sort(levels);
		return levels;
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
