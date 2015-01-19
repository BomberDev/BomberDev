package decor;

import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Rectangle;

public abstract class Brick implements GameEntity, MoveBlocker {

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(100, 100);
	}

}
