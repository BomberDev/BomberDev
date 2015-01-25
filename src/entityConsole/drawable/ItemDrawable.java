package entityConsole.drawable;

import entityConsole.models.BomberEntity;
import gameframework.drawing.GameCanvas;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Point;


public class ItemDrawable extends BomberDrawable implements Overlappable{

	
	
	public ItemDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas, renderingSize, maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		// Note: useless their
	}

	public void animExplode() {
		// TODO implement
	}



}
