package src.bomberdev.game;

import gameframework.game.GameConfiguration;
import gameframework.game.GameUniverse;

public class BomberConfig extends GameConfiguration {

	public BomberConfig() {
		super(30, 60, 16, 3);
	}

	@Override
	public GameUniverse createUniverse() {
		return new BomberUniverse();
	}
}
