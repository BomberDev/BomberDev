package src.bomberdev.model;

import java.awt.Point;

public class IndestructibleBrick extends Brick {

	public IndestructibleBrick(Point position) {
		super(position);
	}

	@Override
	public void onTakingDamage(int damage) {
		// Nothing to do, those bricks are indestructible!!
	}

}
