package drawable;

import gameframework.drawing.GameCanvas;
import java.awt.Point;

import models.BomberEntity;

public class BombDrawable extends BomberDrawable {

	public BombDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas, maxSpriteNumber, maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		// TODO Auto-generated method stub
	}

	public void animExplode() {
		// TODO implement
	}
}
