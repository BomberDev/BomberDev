package src.bomberdev.model;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class Level extends GameLevelDefaultImpl {
	
	public Level(GameData data, BomberMap map) {
		super(data);
		for (int j = 0; j < map.getNbRows(); j++) {
			for (int i = 0; i < map.getNbColumns(); i++) {
				data.getUniverse().addGameEntity(map.getBrickAt(j, i));
			}
		}
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
	}

}
