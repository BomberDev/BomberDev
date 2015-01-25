package entityConsole.models;

import java.awt.Point;

import entityConsole.drawable.BlockDrawable;

public abstract class Block implements BomberEntity {

	protected final Point position;
	protected BlockDrawable drawable;

	public Block(Point position) {
		this.position = position;
	}

	/**
	 * Method called when the entity takes damage.
	 * 
	 * @param damage
	 *            The number of damage taken.
	 */
	public abstract void onTakingDamage();

	@Override
	public Point getPosition() {
		return this.position;
	}

}
