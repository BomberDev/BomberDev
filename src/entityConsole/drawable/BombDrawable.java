package entityConsole.drawable;

import entityConsole.models.Bomb;
import entityConsole.models.BomberEntity;
import gameframework.drawing.GameCanvas;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;
import gameframework.motion.blocking.MoveBlocker;
import java.awt.Point;


public class BombDrawable extends BomberDrawable implements MoveBlocker,Movable{

	
	int Countdown = 22;
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

	@Override
	public SpeedVector getSpeedVector() {
		//isn't really movable but must implement it
		return SpeedVector.createNullVector();
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		// note: nothing to do
	}

	@Override
	public void oneStepMove() {
		this.increment();
		if(this.Countdown--<=0)((Bomb)this.entity).explode();
	}
}
