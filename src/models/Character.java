package models;

import gameframework.drawing.Drawable;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import drawable.CharacterDrawable;

public class Character implements BomberEntity, Movable,Drawable {

	/** The fire power of the bomb in number of tiles. */
	private int bombPower;
	/** The character's number of health points. */
	private int healthPoints;
	/** The character's position in number of tiles . */
	private Point position;
	/** The number of bombs the character can plant at a time. */
	private int bombStock;
	/** The drawable associated with this entity. */
	private CharacterDrawable drawable;
	private SpeedVector speedVector;

	public Character() {
		this(2, 1, new Point(1, 1), 1, new SpeedVector(new Point(0,0)));
	}

	public Character(int bombPower, int healthPoints, Point position,
			int stockBombs,SpeedVector speedVector) {
		this.bombPower = bombPower;
		this.healthPoints = healthPoints;
		this.position = position;
		this.speedVector = speedVector;
	}

	/**
	 * Plants a bomb if the character has a {@link #bombStock} differing from
	 * zero.
	 * 
	 * @return <code>true</code> if the bomb was successfully planted;<br>
	 *         <code>false</code> else;
	 */
	public boolean plantBomb() {
		this.drawable.animPlanting();
		if (this.bombStock > 0) {
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
		//TODO implement
	}

	public void incrementBombStock() {
		this.bombStock++;
	}

	@Override
	public void onTakingDamage(int damage) {
		this.healthPoints -= damage;
		if (this.healthPoints <= 0) {
			die();
		}
	}

	@Override
	public void oneStepMove() {
		// TODO Auto-generated method stub
		
		//Walking plant
		SpeedVector sv = this.getSpeedVector();
		Point dit = sv.getDirection();
		int speed = sv.getSpeed();
		this.drawable.animIdle(sv.getDirection());
		if(!(speed==0||(dit.x==0&&dit.y==0)))this.drawable.animMoving(sv.getDirection());
		else this.drawable.reset();
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.drawable.getRenderingSize(), this.drawable.getRenderingSize());
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public SpeedVector getSpeedVector() {
		return (SpeedVector)this.speedVector.clone();
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		this.speedVector.setDirection(m.getDirection());
		this.speedVector.setSpeed(m.getSpeed());
	}

	@Override
	public void draw(Graphics g) {
		this.drawable.draw(g);
	}

}
