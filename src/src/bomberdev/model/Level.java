package src.bomberdev.model;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class Level extends GameLevelDefaultImpl {
	
	BomberMap map;
	
	public Level(GameData data, BomberMap map) {
		super(data);
	}

	@Override
	protected void init() {
		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				data.getUniverse().addGameEntity(map.getBrickAt(j, i));
			}
		}
	}

}
