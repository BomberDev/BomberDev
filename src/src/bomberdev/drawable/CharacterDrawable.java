package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;

import java.awt.Graphics;
import java.awt.Point;

import src.bomberdev.model.BomberEntity;

public class CharacterDrawable extends BomberDrawable {

	protected static final int SPRITE_SIZE;
	protected static final String FILENAME;
	
	static {
		SPRITE_SIZE = 128;
		FILENAME = "/Resources/Graphics/Characters/bomberman.png";
	}
	
	public CharacterDrawable(BomberEntity entity, GameCanvas canvas) {
		super(FILENAME, entity, canvas);
		this.manager = new SpriteManagerDefaultImpl(this, SPRITE_SIZE, 8);
		init();
	}

	protected void init() {
		this.manager.setTypes("right", "left", "down", "up");
	}

	public void setDirection(Point direction) {
		String type;
		int x = (int) direction.getX();
		int y = (int) direction.getY();

		switch (x) {
		case -1:
			type = "left";
			this.manager.setType(type);
			break;
		case 1:
			type = "right";
			this.manager.setType(type);
			break;

		default:
			switch (y) {
			case -1:
				type = "up";
				this.manager.setType(type);
				break;
			case 1:
				type = "down";
				this.manager.setType(type);
				break;
			default:
				break;
			}
		}
	}

	public void animIdle() {
	}

	public void animMoving() {
		this.manager.increment();
	}

	public void animDying() {
		// TODO: implement
	}
	
	@Override
	public int getSpriteSize() {
		return 1;
	}
}
