package src.bomberdev.model.motion;

import src.bomberdev.model.Character;
import gameframework.motion.MoveStrategyKeyboard;

public class PlayerKeyboard extends MoveStrategyKeyboard {

	public PlayerKeyboard(Character character) {
		super(false);
	}
	
}
