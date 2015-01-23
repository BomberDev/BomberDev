package src.bomberdev.model;

import java.awt.Point;

import src.bomberdev.game.BomberUniverse;


public class ExplodableBlock extends Block {

	public ExplodableBlock(BomberUniverse univ, Point position) {
		super(univ, position);
	}

	
	
	public ExplodableBlock(Point position) {
		super(position);
	}



	@Override
	public void onTakingDamage(int damage) {
		this.drawable.animDestroy();
		// TODO: Delete from list of entities
	}
}
