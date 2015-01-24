package src.bomberdev.model;

import gameframework.drawing.GameCanvas;

import java.awt.Point;

import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.drawable.ExplodableBlockDrawable;

public class ExplodableBlock extends Block {

	public ExplodableBlock(Point position) {
		super(position);
	}

	@Override
	public void onTakingDamage(int damage) {
		this.drawable.animDestroy();
		// TODO: Delete from list of entities
	}

	@Override
	public BomberDrawable draw(GameCanvas canvas) {
		return new ExplodableBlockDrawable(this, canvas);
	}
}
