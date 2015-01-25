package src.bomberdev.model;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

import java.io.File;

import src.bomberdev.game.Objective;

public class Level extends GameLevelDefaultImpl {

	protected static final String PACKAGE_NAME = "target/classes/Resources/Maps/";

	protected BomberMap map;
	protected File actualLevel;
	protected Objective objective;

	public Level(GameData data, Objective objective) {
		super(data);
		this.objective = objective;
		this.actualLevel = new File(getMapsFiles(PACKAGE_NAME)[0]);
	}

	public String[] getMapsFiles(String path) {
		File folder = new File(path);
		return folder.list();
	}

	@Override
	protected void init() {
		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				data.getUniverse().addGameEntity(map.getBrickAt(j, i));
			}
		}
	}

	@Override
	public void end() {
		if (objective.isDone()) {
			super.end();
		}
	}
}
