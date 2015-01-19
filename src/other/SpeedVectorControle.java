package other;

import gameframework.game.GameEntity;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

import java.awt.Point;
import java.awt.Rectangle;

public class SpeedVectorControle implements GameEntity, Movable {
	ChangableByStep sv;

	public SpeedVectorControle(ChangableByStep sv) {
		this.sv = sv;
	}

	@Override
	public Rectangle getBoundingBox() {
		return null;
	}

	@Override
	public Point getPosition() {
		return null;
	}

	@Override
	public SpeedVector getSpeedVector() {
		return null;
	}

	@Override
	public void setSpeedVector(SpeedVector m) {

	}

	@Override
	public void oneStepMove() {
		this.sv.oneStepChange();
	}

}
