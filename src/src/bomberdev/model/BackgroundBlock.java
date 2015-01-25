package src.bomberdev.model;

import gameframework.drawing.GameCanvas;

import java.awt.Point;

import src.bomberdev.drawable.BackgroundDrawable;
import src.bomberdev.drawable.BomberDrawable;

public class BackgroundBlock extends Block {
	public BackgroundBlock(Point position) {
		super(position);
	}

	@Override
	public void onTakingDamage(int damage) {
	}

	@Override
	public BomberDrawable draw(GameCanvas canvas) {
		return new BackgroundDrawable(this, canvas);
	}
}
