package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import gameframework.motion.GameMovableDriverDefaultImpl;

import java.awt.Point;

import other.PlayerKeyboard;
import src.bomberdev.model.BomberEntity;

public class CharacterDrawable extends BomberDrawable {

	public CharacterDrawable(String filename, BomberEntity entity, GameCanvas canvas) {
		super(filename, entity, canvas);
		this.manager.setTypes("right", "left", "down", "up");
		init();
	}
	
	protected void init() {
		this.entity.getUniverse().addGameEntity(this);
	}
	
	public void setDirection(Point direction) {
		String type;
		int x = (int) direction.getX();
		int y = (int) direction.getY();
		
		switch(x) {
			case -1: type = "left"; break;
			case 1:	type = "right"; break;
				
			default:
				switch(y) {
					case -1: type = "up"; break;
					case 1: type = "down"; break;
					default: type = "null"; break;
				}
		}
	
		this.manager.setType(type);
	}

	public void animIdle() {
	}
	
	public void animMoving() {
		this.manager.increment();
	}
	
	public void animDying() {
		// TODO: implement
	}
}
