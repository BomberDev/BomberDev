package src.bomberdev.drawable;

import java.awt.Point;

import gameframework.drawing.SpriteManager;
import src.bomberdev.model.BomberEntity;

public class BombDrawable extends BomberDrawable {

	public BombDrawable(SpriteManager manager, BomberEntity entity) {
		super(manager, entity);
	}
	
	@Override
	public void animIdle(Point direction) {
		// TODO Auto-generated method stub
	}

	public void animExplode() {
		// TODO implement
	}
}
