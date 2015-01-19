package drawable;

import gameframework.drawing.GameCanvas;
import java.awt.Point;

import models.BomberEntity;

public class CharacterDrawable extends BomberDrawable {

	public CharacterDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas, maxSpriteNumber, maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		// TODO: implement
	}

	public void animMoving(Point direction) {
		// TODO: implement
	}

	public void animPlanting() {
		// TODO: implement
	}

	public void animDying() {
		// TODO: implement
	}
}
