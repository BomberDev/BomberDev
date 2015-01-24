package drawable;

import gameframework.drawing.GameCanvas;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import models.BomberEntity;

public class BrickDrawable extends BomberDrawable implements MoveBlocker  {

	public BrickDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas, renderingSize, maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		this.spriteManager.setType("left");
	}

	public void animDestroy() {
		//TODO
		this.visible=false;
	}

}
