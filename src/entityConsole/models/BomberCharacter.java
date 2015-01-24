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
	/** The character's position in number of tiles . */
	private Point position;
	/** The number of bombs the character can plant at a time. */
	private int bombStock;
	/** The drawable associated with this entity. */
	private CharacterDrawable drawable;
	private SpeedVector speedVector;
	private MoveStrategy strategy;
	private BombConsole console;

	public BomberCharacter(GameData data,MoveStrategy strategy) {
		this(2, 1, new Point(1, 1), 1, data, strategy);
	}

	public BomberCharacter(int bombPower, int healthPoints, Point position,
			int stockBombs, GameData data,MoveStrategy strategy) {
		this.bombPower = bombPower;
		this.healthPoints = healthPoints;
		this.position = position;
		this.console=new BombConsole("/Bomb/Bomb.png", 3, this);
		
		this.strategy=strategy;
		
		strategy.getSpeedVector().setDirection(position);
		strategy.getSpeedVector().setSpeed(10);
		this.speedVector=strategy.getSpeedVector();
		GameMovableDriverDefaultImpl driver = new GameMovableDriverDefaultImpl();
		driver.setStrategy(strategy);
		driver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		setDriver(driver);
	}

	public void setDrawable(CharacterDrawable drawable){
		this.drawable=drawable;
	}
	
	public void initDrawable(String filename,GameData data,int maxSpriteNumber){
		this.drawable=new CharacterDrawable(filename, data.getCanvas(),data.getConfiguration().getSpriteSize() , maxSpriteNumber, this);
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
		this.drawable.animPlanting();
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
		Dimension dimension = new Dimension();
		dimension.setSize(this.drawable.getRenderingSize(), this.drawable.getRenderingSize());
		return new Rectangle(this.getPosition(),dimension);
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

	@Override
	public void oneStepMoveAddedBehavior() {
		SpriteManager m = this.drawable.getSpriteManager();
		int x = (int) this.strategy.getSpeedVector().getDirection().distance(0, 0);
		Point p = this.strategy.getSpeedVector().getDirection();
		if(x!=0){
			if(p.x>0)m.setType("right");
			else if(p.x<0)m.setType("left");
			else if(p.y>0)m.setType("down");
			else m.setType("up");
			m.increment();
		}
		else m.reset();
		System.out.println(this.getPosition().x + " "+this.getPosition().y);
	}

}
