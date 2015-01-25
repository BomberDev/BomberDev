package src.bomberdev.model;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameUniverse;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategy;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Point;
import java.awt.Rectangle;

import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.drawable.CharacterDrawable;
import src.bomberdev.game.BomberUniverse;
import src.bomberdev.model.motion.PlayerKeyboard;

public class Character extends GameMovable implements BomberEntity {

	private final BomberUniverse univ;
	/** The fire power of the bomb in number of health points taken when it damages. */
	private int bombPower;
	/** The area fire power of the bomb in number of tiles. */
	private int bombArea;
	/** The character's number of health points. */
	private int healthPoints;
	/** The number of bombs the character can plant at a time. */
	private int bombStock;
	/** The direction the character is facing. */
	private Point direction;
	/** The drawable associated with this entity. */
	private CharacterDrawable drawable;
	
	private final MoveStrategy strategy;
	
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
	
	public Character(GameUniverse gameUniverse, MoveStrategy strat) {
		this(gameUniverse,
			 strat,
			 DEFAULT_POWER,
			 DEFAULT_AREA,
			 DEFAULT_HEALTH,
			 DEFAULT_STOCK);
	}
	
	public Character(GameUniverse gameUniverse, MoveStrategy strat, int bombPower,
			int bombArea, int healthPoints, int stockBombs) {
		super();
		
		this.univ = (BomberUniverse) gameUniverse;
		this.strategy = strat;
		this.bombPower = bombPower;
		this.bombArea = bombArea;
		this.healthPoints = healthPoints;
		this.direction = new Point(0, 1);
		this.position.setLocation(new Point(0,0));
		
		init();
	}

	protected void init() {
		this.univ.addGameEntity(this);
		((GameMovableDriverDefaultImpl) this.moveDriver).setStrategy(this.strategy);
	}
	
	/**
	 * Plants a bomb if the character has a {@link #bombStock} differing from zero.
	 * @return <code>true</code> if the bomb was successfully planted;<br>
	 * 			<code>false</code> else;
	 */
	
	public boolean plantBomb() {
		if(this.bombStock > 0) {
			// TODO: create a bomb
			this.bombStock--;
			return true;
		}
		
		return false;
	}
	
	
	private void die() {
		this.drawable.animDying();
	}

	public void incrementBombStock() {
		this.bombStock++;
	}
	
	/* Getters and setters */
	
	public int getBombArea() {
		return this.bombArea;
	}

	public void setBombArea(int bombArea) {
		this.bombArea = bombArea;
	}

	public int getBombPower() {
		return bombPower;
	}

	public void setBombPower(int bombPower) {
		this.bombPower = bombPower;
	}

	public Point getDirection() {
		return this.direction;
	}
	
	@Override
	public void onTakingDamage(int damage) {
		this.healthPoints -= damage;
		if(this.healthPoints <= 0) {
			die();
		}
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(64, 64);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		Point dir = this.strategy.getSpeedVector().getDirection();
		
		if(!this.direction.equals(dir)) {
			this.direction = dir;
			this.drawable.setDirection(dir);
		}
		
		if(!this.direction.equals(new Point(0,0))) {
			this.drawable.animMoving();
		}
	}
	
	@Override
	public void setDrawable(BomberDrawable drawable) {
		this.drawable = (CharacterDrawable) drawable;
	}
	
	@Override
	public BomberUniverse getUniverse() {
		return this.univ;
	}

	@Override
	public BomberDrawable draw(GameCanvas canvas) {
		return new CharacterDrawable(this, canvas);
	}
}
