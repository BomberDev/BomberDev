package models;

import java.awt.Point;

public class IndestructibleBrick extends Brick {

	public IndestructibleBrick(Point position) {
		super(position);
	}
	
	public IndestructibleBrick(){
		this(new Point(0,0));
	}

	@Override
	public void onTakingDamage(int damage) {
		// Nothing to do, those bricks are indestructible!!
	}

}
