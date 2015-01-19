package models;

import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Timer;

import drawable.BombDrawable;

public class Bomb implements BomberEntity, MoveBlocker {

	private final Character owner;
	private final int power;
	protected Point position;
	protected Timer timer;
	protected BombDrawable drawable;
	protected GameData data;

	public Bomb(Character owner, Point position, GameData data) {
		this.owner = owner;
		this.power = owner.getFirePower();
		this.position = position;
	}

	public void explode() {
		// check for all GameEntity caught in the explosion.
		Iterator<GameEntity> entitys = this.data.getUniverse().gameEntities();
		for(GameEntity entity;entitys.hasNext();){
			entity=entitys.next();
			if(entity instanceof BomberEntity){//one who will be damaged
				Point p = ((BomberEntity) entity).getPosition();
				int dx = p.x;
				int dy = p.y;
				int fx = this.position.x;
				int fy = this.position.y;
				if((dx>fx-this.power)&&(dx<fx+power)&&(dy>fy-this.power)&&(dy<fy+this.power)){
					//TODO: Destroy this entity and play the animation
				}
			}
		}
		//----
		this.drawable.animExplode();
		this.owner.incrementBombStock();
	}

	@Override
	public void onTakingDamage(int damage) {
		explode();
	}

	@Override
	public Rectangle getBoundingBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

}
