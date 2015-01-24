package entityConsole.models;

import gameframework.drawing.Drawable;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Timer;

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
		// check for all GameEntity caught in the explosion.
		Iterator<GameEntity> entitys = this.data.getUniverse().getGameEntitiesIterator();
		for(GameEntity entity;entitys.hasNext();){
			entity=entitys.next();
			if(entity.equals(this))continue;
			if(entity instanceof BomberEntity){//one who will be damaged
				Point p = ((BomberEntity) entity).getPosition();
				int size = this.getDrawable().getRenderingSize();
				int dx = p.x;
				int dy = p.y;
				int fx = this.position.x;
				int fy = this.position.y;
				if(((dx<=fx+size*0.5)&&(dx>=fx-size*0.5)&&(dy<=fy+size*(power))&&(dy>=fy-size*(power)))||((dy<=fy+size*0.5)&&(dy>=fy-size*0.5)&&(dx<=fx+size*(power))&&(dx>=fx-size*(power)))){
					//TODO: Destroy this entity and play the animation
					((BomberEntity) entity).onTakingDamage(this.power);
				}
			}
		}
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
