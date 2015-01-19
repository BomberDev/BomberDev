package models;

import java.awt.Point;


public class DestructibleBrick extends Brick {

	public DestructibleBrick(Point position) {
		super(position);
	}

	
	
	@Override
	public void onTakingDamage(int damage) {
		this.drawable.animDestroy();
		// TODO: Delete from list of entities
	}

}
