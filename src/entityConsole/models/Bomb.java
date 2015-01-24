package entityConsole.models;

import gameframework.drawing.Drawable;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Timer;

import entityConsole.drawable.BombDrawable;

public class Bomb implements BomberEntity, MoveBlocker, Drawable {

	private final BomberCharacter owner;
	private final int power;
	protected Point position;
	protected Timer timer;
	protected BombDrawable drawable;
	protected GameUniverse gameUniverse;

	public Bomb(BomberCharacter owner, Point position, GameUniverse gameUniverse) {
		this.owner = owner;
		this.power = owner.getFirePower();
		this.position = position;
		this.gameUniverse=gameUniverse;
	}
	
	public void createDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber){
		this.drawable=new BombDrawable(filename, canvas, renderingSize, maxSpriteNumber, this);
	}

	public void explode() {
		// check for all GameEntity caught in the explosion.
		Iterator<GameEntity> entitys = this.gameUniverse.getGameEntitiesIterator();
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
	public Rectangle getBoundingBox() {
		return this.drawable.getBoundingBox();
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public void draw(Graphics g) {
		this.drawable.draw(g);
	}

}
