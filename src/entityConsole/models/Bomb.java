package entityConsole.models;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import java.awt.Point;
import java.util.Timer;

import other.Methods;


import entityConsole.drawable.BombDrawable;

public class Bomb implements BomberEntity {

	private final BomberCharacter owner;
	private final int power;
	protected Point position;
	protected Timer timer;
	protected BombDrawable drawable;
	protected GameData data;

	public Bomb(BomberCharacter owner, Point position, GameData data) {
		this.owner = owner;
		this.power = owner.getFirePower();
		this.position = position;
		this.data=data;
	}
	
	public void createDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber){
		this.drawable=new BombDrawable(filename, canvas, renderingSize, maxSpriteNumber, this);
	}

	public BombDrawable getDrawable(){
		return this.drawable;
	}
	
	public void explode() {
		//TODO this method isn't right. it must be stop when meet a brick.
		
		// check for all GameEntity caught in the explosion.
		Methods.explode(power, data, this, this.position.x, this.position.y);
		//----
		this.owner.getConsole().deleteEntity(this);
		this.owner.incrementBombStock();
	}

	@Override
	public void onTakingDamage(int damage) {
		explode();
	}

	@Override
	public Point getPosition() {
		return this.position;
	}


}
