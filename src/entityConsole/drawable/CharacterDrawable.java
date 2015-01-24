package entityConsole.drawable;

import entityConsole.models.BomberEntity;
import gameframework.drawing.GameCanvas;
import java.awt.Point;


public class CharacterDrawable extends BomberDrawable {

	public CharacterDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas, maxSpriteNumber, maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		int x = direction.x;
		int y = direction.y;
		if(x<0)this.spriteManager.setType("left");
		else if(x>0)this.spriteManager.setType("right");
		else if(y<0)this.spriteManager.setType("up");
		else this.spriteManager.setType("down");//(0,1) or (0,0)
	}

	public void reset(){
		this.spriteManager.reset();
	}
	
	public void animMoving(Point direction) {
		this.spriteManager.increment();
	}

	public void animPlanting() {
		// TODO: implement
	}

	public void animDying() {
		// TODO: implement
	}
}
