package entityConsole.models;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategy;
import gameframework.motion.SpeedVector;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import entityConsole.BombConsole;
import entityConsole.drawable.CharacterDrawable;

public class BomberCharacter extends GameMovable implements BomberEntity {

	/** The fire power of the bomb in number of tiles. */
	private int bombPower;
	/** The character's number of health points. */
	private int healthPoints;
	/** The number of bombs the character can plant at a time. */
	private int bombStock;
	/** The drawable associated with this entity. */
	protected CharacterDrawable drawable;
	int speed;
	/**
	 * it's only use for get the vector tendency. the real SpeedVector is from
	 * drive.
	 */
	private MoveStrategy strategy;
	/**
	 * Which to create and delete a bomb.
	 */
	private BombConsole console;
	protected GameData data;

	public BomberCharacter(GameData data, MoveStrategy strategy) {
		this(2, 1, 1, 2, data, strategy);
	}

	// maybe we should link the health to life, for player.
	public BomberCharacter(int bombPower, int healthPoints, int stockBombs,
			int speed, GameData data, MoveStrategy strategy) {
		this.bombPower = bombPower;
		this.healthPoints = healthPoints;
		this.bombStock = stockBombs;
		this.console = new BombConsole("/Bomb/Bomb.png", 3, this);
		this.console.setGameData(data);
		this.strategy = strategy;
		this.speed = speed;
		this.data = data;
		GameMovableDriverDefaultImpl driver = new GameMovableDriverDefaultImpl();
		driver.setStrategy(strategy);
		driver.setmoveBlockerChecker(data.getMoveBlockerChecker());
		setDriver(driver);
		this.strategy.getSpeedVector().setSpeed(2 + speed * 2);
	}

	public void setGameData(GameData data) {
		this.data = data;
		this.console.setGameData(data);
	}

	public void incrimentSpeed() {
		// TODO unverified
		this.strategy.getSpeedVector().setSpeed(
				this.strategy.getSpeedVector().getSpeed() + 2);
		this.speed++;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setDrawable(CharacterDrawable drawable) {
		this.drawable = drawable;
	}

	public void initDrawable(String filename, GameData data, int maxSpriteNumber) {
		this.drawable = new CharacterDrawable(filename, data.getCanvas(), data
				.getConfiguration().getSpriteSize() * 2, maxSpriteNumber, this);
		data.getOverlapProcessor().addOverlappable(drawable);
	}

	public BombConsole getConsole() {
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
		if (this.healthPoints <= 0)
			return false;
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

	public CharacterDrawable getDrawable(){
		return this.drawable;
	}
	private void die() {
		this.drawable.animDying(data);
		this.data.getUniverse().removeGameEntity(this);
	}

	public void setPosition(int x, int y) {
		this.position.setLocation(x
				* this.data.getConfiguration().getSpriteSize(), y
				* this.data.getConfiguration().getSpriteSize());
	}

	public void incrementBombStock() {
		this.bombStock++;
	}

	public void imcrementPower() {
		if (this.bombPower < 7)
			this.bombPower++;
	}

	@Override
	public void onTakingDamage() {
		this.healthPoints--;
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

	public void draw(Graphics g) {
		this.drawable.draw(g);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// Walking plant
		SpeedVector sv = this.strategy.getSpeedVector();
		Point dit = sv.getDirection();
		int speed = sv.getSpeed();
		this.drawable.animIdle(sv.getDirection());
		if (!(speed == 0 || (dit.x == 0 && dit.y == 0)))
			this.drawable.animMoving(sv.getDirection());
		else
			this.drawable.reset();
	}

}
