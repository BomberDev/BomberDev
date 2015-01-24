package src.bomberdev.model;

import gameframework.drawing.GameCanvas;

import java.awt.Point;

import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.drawable.SolidBlockDrawable;
import src.bomberdev.game.BomberUniverse;

public class SolidBlock extends Block {

	public SolidBlock(BomberUniverse univ, Point position) {
		super(univ, position);
	}

	public SolidBlock(Point position) {
		super(position);
	}

	@Override
	public void onTakingDamage(int damage) {
		// Nothing to do, those bricks are indestructible!!
	}

	@Override
	public BomberDrawable draw(GameCanvas canvas) {
		return new SolidBlockDrawable(this, canvas);
	}

}
