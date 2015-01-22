package src.bomberdev.model;

import java.awt.Point;

import src.bomberdev.game.BomberUniverse;

public class IndestructibleBrick extends Brick {

	public IndestructibleBrick(BomberUniverse univ, Point position) {
		super(univ, position);
	}

	@Override
	public void onTakingDamage(int damage) {
		// Nothing to do, those bricks are indestructible!!
	}

}
