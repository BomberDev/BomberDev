package entityConsole.models;

import gameframework.drawing.Drawable;
import gameframework.drawing.SpriteManager;
import gameframework.game.GameData;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategy;
import gameframework.motion.SpeedVector;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import entityConsole.BombConsole;
import entityConsole.drawable.CharacterDrawable;

public class BomberCharacter extends GameMovable implements BomberEntity,Drawable {

	/** The fire power of the bomb in number of tiles. */
	private int bombPower;
	/** The character's number of health points. */
	private int healthPoints;
	/** The number of bombs the character can plant at a time. */
	private int bombStock;
	/** The drawable associated with this entity. */
	private CharacterDrawable drawable;
	private MoveStrategy strategy;
	private BombConsole console;

	public BomberCharacter(GameData data,MoveStrategy strategy) {
		this(2, 1, 1, data, strategy);
	}

	public BomberCharacter(int bombPower, int healthPoints,
			int stockBombs, GameData data,MoveStrategy strategy) {
		this.bombPower = bombPower;
		this.healthPoints = healthPoints;
		this.bombStock=stockBombs;
		this.console=new BombConsole("/Bomb/Bomb.png", 3, this);
		this.console.setGameData(data);
		this.strategy=strategy;
		
		
		
		GameMovableDriverDefaultImpl driver = new GameMovableDriverDefaultImpl();
		driver.setStrategy(strategy);
		driver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		setDriver(driver);
	}

	public void setDrawable(CharacterDrawable drawable){
		this.drawable=drawable;
	}
	
	public void initDrawable(String filename,GameData data,int maxSpriteNumber){
		this.drawable=new CharacterDrawable(filename, data.getCanvas(),data.getConfiguration().getSpriteSize()*2 , maxSpriteNumber, this);
	}
	
	public BombConsole getConsole(){
		return this.console;
	}
	
	
	/**
	 * Plants a bomb if the character has a {@link #bombStock} differing from
	 * zero.
	 * 
	 * @return <code>true</code> if the bomb was successfully planted;<br>
	 *         <code>false</code> else;
	 */
	public boolean plantBomb() {
		if (this.bombStock > 0) {
			this.console.createEntity(this.position.x, this.position.y);
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

	public void setPosition(int x,int y){
		this.position.setLocation(x*this.drawable.getRenderingSize(), y*this.drawable.getRenderingSize());
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

	@Override
	public void oneStepMoveAddedBehavior() {
		//Walking plant
				SpeedVector sv = this.strategy.getSpeedVector();
				Point dit = sv.getDirection();
				int speed = sv.getSpeed();
				this.drawable.animIdle(sv.getDirection());
				if(!(speed==0||(dit.x==0&&dit.y==0)))this.drawable.animMoving(sv.getDirection());
				else this.drawable.reset();
	}

}
