package other;

import gameframework.motion.SpeedVector;

import java.awt.Point;

public abstract class SpeedVectorAutoChanging extends SpeedVector implements
		ChangableByStep {

	protected int speedLimit;

	public SpeedVectorAutoChanging(int speedLimit) {
		super(new Point(0, 0));
		this.speedLimit = speedLimit;
	}

	protected abstract Point getGVector();

	protected void setGVectorLocation(int x, int y) {
		this.getGVector().setLocation(x, y);
	}

	public void putChanging(SpeedVector addition) {
		Point goal = getGoal(addition);
		this.setGVectorLocation(this.getGVector().x + goal.x,
				this.getGVector().y + goal.y);
	}

	public void setSpeedVector(SpeedVector sv) {
		this.setDirection(sv.getDirection());
		this.setSpeed(sv.getSpeed());
	}

	public void removeChanging(SpeedVector addition) {
		SpeedVector s = (SpeedVector) addition.clone();
		s.setSpeed(s.getSpeed() * (-1));
		putChanging(s);
	}

	protected static Point getGoal(SpeedVector sv) {
		Point current = sv.getDirection();
		current.x *= sv.getSpeed();
		current.y *= sv.getSpeed();
		return current;
	}

	@Override
	public void oneStepChange() {
		Point goal = this.getGVector();
		this.setDirection(new Point(this.getDirection().x + goal.x, this
				.getDirection().y + goal.y));
		if (this.speedLimit == 0)
			return;
		double speed = Math.sqrt(this.getDirection().x * this.getDirection().x
				+ this.getDirection().y * this.getDirection().y);
		if (speed > this.speedLimit) {
			this.getDirection().x = (int) (this.getDirection().x / speed * this.speedLimit);
			this.getDirection().y = (int) (this.getDirection().y / speed * this.speedLimit);
		}
	}

}
