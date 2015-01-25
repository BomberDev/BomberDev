package entityConsole.models;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import other.Methods;


import entityConsole.drawable.BombDrawable;

public class Bomb implements BomberEntity,Movable {

	private final BomberCharacter owner;
	private final int power;
	protected Point position;
	protected BombDrawable drawable;
	protected GameData data;
	int Countdown = 75;
	
	public Bomb(BomberCharacter owner, Point position, GameData data) {
		this.owner = owner;
		this.power = owner.getFirePower();
		this.position = position;
		this.data=data;
	}
	
	public void createDrawable(String filename,int maxSpriteNumber){
		this.createDrawable(filename, data.getCanvas(), data.getConfiguration().getSpriteSize(), maxSpriteNumber);
	}
	
	public void createDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber){
		this.drawable=new BombDrawable(filename, canvas, renderingSize, maxSpriteNumber, this);
	}

	public BombDrawable getDrawable(){
		return this.drawable;
	}
	public void explode() {
		LinkedList<GameEntity> ignore = new LinkedList<>();
		ignore.add(this);
		explode(ignore);
	}
	public void explode(List<GameEntity> ignore) {
		//TODO this method isn't right. it must be stop when meet a brick.
		
		if(!ignore.contains(this))ignore.add(this);
		// check for all GameEntity caught in the explosion.
		Methods.explode(power, data, ignore, this.position.x, this.position.y);
		//----
		this.owner.getConsole().deleteEntity(this);
		this.owner.incrementBombStock();
	}

	@Override
	public void onTakingDamage() {
		explode();
	}
	public void onTakingDamage(List<GameEntity>ignore) {
		explode(ignore);
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public Rectangle getBoundingBox() {
		return this.drawable.getBoundingBox();
	}

	@Override
	public SpeedVector getSpeedVector() {
		return SpeedVector.createNullVector();
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		
	}

	@Override
	public void oneStepMove() {
		this.drawable.increment();
		if(this.Countdown--<=0)explode();
	}


}
