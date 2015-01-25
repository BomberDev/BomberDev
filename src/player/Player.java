package player;

import entityConsole.models.BomberCharacter;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;

public class Player extends BomberCharacter {

	public Player(GameData data, MoveStrategy strategy) {
		super(data, strategy);
	}

}
