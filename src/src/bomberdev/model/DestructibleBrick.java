package src.bomberdev.model;

import java.awt.Point;

import src.bomberdev.game.BomberUniverse;


public class DestructibleBrick extends Brick {

	public DestructibleBrick(BomberUniverse univ, Point position) {
		super(univ, position);
	}

	
	
	@Override
	public void onTakingDamage(int damage) {
		this.drawable.animDestroy();
		// TODO: Delete from list of entities
	}
}
