package entityConsole.drawable;

import entityConsole.models.BomberEntity;
import entityConsole.models.Brick;
import gameframework.game.GameData;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

import java.awt.Point;

public class SelfDestructionDrawable extends BomberDrawable implements Movable {
	private int display;
	private GameData data;
	public SelfDestructionDrawable(String filename,GameData data,int maxSpriteNumber,int displayNumber,BomberEntity entity) {
		super(filename, data.getCanvas(), data.getConfiguration().getSpriteSize(), maxSpriteNumber, entity);
		this.display=displayNumber;
		this.data=data;
		data.getUniverse().addGameEntity(this);
	}

	public static void create(String filename,GameData data,int maxSpriteNumber,int displayNumber,BomberEntity entity){
		new SelfDestructionDrawable(filename, data, maxSpriteNumber, displayNumber,entity);
	}
	public static void create(String filename,GameData data,int maxSpriteNumber,int displayNumber,Point position){
		new SelfDestructionDrawable(filename, data, maxSpriteNumber, displayNumber,new Brick(position){

			@Override
			public void onTakingDamage() {
				
			}});
	}
	
	@Override
	public void animIdle(Point direction) {
		//note:nothing to do
	}

	@Override
	public SpeedVector getSpeedVector() {
		return SpeedVector.createNullVector();
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		//note:nothing to do
	}

	@Override
	public void oneStepMove() {
		this.increment();
		if(display--<=0)data.getUniverse().removeGameEntity(this);
	}
	
	

}
