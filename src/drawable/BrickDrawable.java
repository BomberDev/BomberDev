package drawable;

import gameframework.drawing.SpriteManager;

import java.awt.Point;

import models.BomberEntity;

public class BrickDrawable extends BomberDrawable {

	public BrickDrawable(SpriteManager manager, BomberEntity entity) {
		super(manager, entity);
	}

	@Override
	public void animIdle(Point direction) {
		// TODO Auto-generated method stub

	}

	public void animDestroy() {
		// TODO Implement
	}
}
