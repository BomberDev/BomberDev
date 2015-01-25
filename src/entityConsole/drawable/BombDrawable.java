package entityConsole.drawable;

import entityConsole.models.BomberEntity;
import gameframework.drawing.GameCanvas;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Point;


public class BombDrawable extends BomberDrawable implements MoveBlocker,Overlappable{

	
	
	public BombDrawable(String filename, GameCanvas canvas, int renderingSize,
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
