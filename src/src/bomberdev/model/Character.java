package src.bomberdev.model;

import java.awt.Point;
import java.awt.Rectangle;

import src.bomberdev.drawable.CharacterDrawable;
import gameframework.game.GameEntity;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;
import gameframework.motion.blocking.MoveBlocker;

public class Character implements BomberEntity, Movable, MoveBlocker {

	/** The fire power of the bomb in number of health points taken when it damages. */
	private int bombPower;
	/** The area fire power of the bomb in number of tiles. */
	private int bombArea;
	/** The character's number of health points. */
	private int healthPoints;
	/** The character's position in number of tiles .*/
	private Point position;
	/** The number of bombs the character can plant at a time. */
	private int bombStock;
	/** The drawable associated with this entity. */
	private CharacterDrawable drawable;
	
	private static final int DEFAULT_POWER;
	private static final int DEFAULT_AREA;
	private static final int DEFAULT_HEALTH;
	private static final int DEFAULT_STOCK;
	
	static {
		 DEFAULT_POWER = 1;
		 DEFAULT_AREA = 2;
		 DEFAULT_HEALTH = 1;
		 DEFAULT_STOCK = 1;
	}
	
	public Character() {
		this(DEFAULT_POWER,
			 DEFAULT_AREA,
			 DEFAULT_HEALTH,
			 new Point(1,1),
			 DEFAULT_STOCK);
	}
	
	public Character(int bombPower, int bombArea, int healthPoints, Point position, int stockBombs) {
		this.bombPower = bombPower;
		this.bombArea = bombArea;
		this.healthPoints = healthPoints;
		this.position = position;
	}
	
	/**
	 * Plants a bomb if the character has a {@link #bombStock} differing from zero.
	 * @return <code>true</code> if the bomb was successfully planted;<br>
	 * 			<code>false</code> else;
	 */
	
	public boolean plantBomb() {
		this.drawable.animPlanting();
		if(this.bombStock > 0) {
			// TODO: create a bomb
			this.bombStock--;
			return true;
		}
		
		return false;
	}
	
	
	public int getFirePower() {
		return this.bombPower;
	}

	private void die() {
		this.drawable.animDying();
	}

	public void incrementBombStock() {
		this.bombStock++;
	}
	
	@Override
	public void onTakingDamage(int damage) {
		this.healthPoints -= damage;
		if(this.healthPoints <= 0) {
			die();
		}
	}

	@Override
	public void oneStepMove() {
		// TODO Auto-generated method stub
		
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

	@Override
	public SpeedVector getSpeedVector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		// TODO Auto-generated method stub
		
	}

	public int getFireArea() {
		return 0;
	}

}
