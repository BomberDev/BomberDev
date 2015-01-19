package drawable;

import gameframework.drawing.SpriteManager;

import java.awt.Point;

import models.BomberEntity;

public class CharacterDrawable extends BomberDrawable {

	public CharacterDrawable(SpriteManager manager, BomberEntity entity) {
		super(manager, entity);
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
