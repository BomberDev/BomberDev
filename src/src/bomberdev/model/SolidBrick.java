package src.bomberdev.model;

import java.awt.Point;

<<<<<<< HEAD:src/src/bomberdev/model/SolidBrick.java
public class SolidBrick extends Brick {

	public SolidBrick(Point position) {
		super(position);
=======
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
