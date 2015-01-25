package entityConsole.models;

import java.awt.Point;

import entityConsole.drawable.BrickDrawable;

public abstract class Brick implements BomberEntity {

	protected final Point position;
	protected BrickDrawable drawable;

	public Brick(Point position) {
		this.position = position;
	}
	
	/**
	 * Method called when the entity takes damage.
	 * @param damage The number of damage taken.
	 */
	public abstract void onTakingDamage();
	
	@Override
	public Point getPosition() {
		return this.position;
	}


}
