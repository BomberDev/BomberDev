package src.bomberdev.game;

import gameframework.game.GameConfiguration;
import gameframework.game.GameUniverse;

public class BomberConfig extends GameConfiguration {

	public BomberConfig() {
		super(13, 15, 64, 1);
	}

	@Override
	public GameUniverse createUniverse() {
		return new BomberUniverse();
	}
}
