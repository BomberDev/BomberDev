package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;

import java.awt.Point;

import src.bomberdev.model.BomberEntity;

public class CharacterDrawable extends BomberDrawable {

	public CharacterDrawable(String filename, BomberEntity entity,
			GameCanvas canvas) {
		super(filename, entity, canvas);
		this.manager = new SpriteManagerDefaultImpl(this, 128, 8);
		init();
	}

	protected void init() {
		this.manager.setTypes("right", "left", "down", "up");
		this.entity.getUniverse().addGameEntity(this);
	}

	public void setDirection(Point direction) {
		String type;
		int x = (int) direction.getX();
		int y = (int) direction.getY();

		switch (x) {
		case -1:
			type = "left";
			break;
		case 1:
			type = "right";
			break;

		default:
			switch (y) {
			case -1:
				type = "up";
				break;
			case 1:
				type = "down";
				break;
			default:
				type = "down";
				break;
			}
		}

		this.manager.setType(type);
	}

	@Override
	public void animIdle() {
	}

	public void animMoving() {
		this.manager.increment();
	}

	public void animDying() {
		// TODO: implement
	}
}
