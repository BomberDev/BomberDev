package entityConsole.drawable;

import entityConsole.models.Bomb;
import entityConsole.models.BomberEntity;
import gameframework.drawing.GameCanvas;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;


public class BombDrawable extends BomberDrawable implements MoveBlocker,Movable{

	
	int Countdown = 15;
	public BombDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas, renderingSize, maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		// TODO Auto-generated method stub
	}

	public void animExplode() {
		// TODO implement
	}

	@Override
	public SpeedVector getSpeedVector() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void oneStepMove() {
		this.increment();
		if(this.Countdown--<=0)((Bomb)this.entity).explode();
	}
}
