package player;

import gameframework.base.ObjectWithBoundedBox;
import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.Movable;
import gameframework.motion.MoveStrategy;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameMovable implements GameEntity, Drawable,
		Movable, ObjectWithBoundedBox {

	protected SpriteManagerDefaultImpl spriteManager;
	protected boolean increment = false;
	protected boolean inAction;
	protected int step = 1;
	protected int maxStep;

	public Player(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, MoveStrategy strategy) {
		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				filename, canvas), renderingSize, maxSpriteNumber);

		this.spriteManager.setTypes("1", "2", "3", "4", "5", "6");
		strategy.getSpeedVector().setDirection(position);
		strategy.getSpeedVector().setSpeed(5);

		GameMovableDriverDefaultImpl driver = new GameMovableDriverDefaultImpl();
		driver.setStrategy(strategy);
		setDriver(driver);
	}

	public void setPoint(int x, int y) {
		this.position.setLocation(x, y);
	}

	public void increment() {
		this.step = (step >= 10 ? 3 : step + 1);
		this.spriteManager.setIncrement(step - 1);
		if (inAction && (step >= maxStep)) {
			this.inAction = false;
			this.setType(3);
			this.spriteManager.reset();
			this.lock();
		}
	}

	public void setType(int type) {
		this.setType("" + type);
		this.spriteManager.reset();
	}

	public void setType(String type) {
		this.spriteManager.setType(type);
		this.step = 1;
	}

	public void lock() {
		this.increment = false;
	}

	public void unlock() {
		this.increment = true;
	}

	public boolean inAction() {
		return this.inAction;
	}

	public void action(int type) {
		if (type == 1) {
			if (inAction)
				return;
			this.maxStep = 10;
			this.setType(1);
			this.unlock();
			this.inAction = true;
		} else if (type == 2) {
			if (inAction)
				return;
			this.maxStep = 9;
			this.setType(2);
			this.unlock();
			this.inAction = true;
		}
	}

	@Override
	public void draw(Graphics g) {
		spriteManager.draw(g, this.position);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(100, 100);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		int x = (int) this.speedVector.getDirection().distance(0, 0);
		if (!this.increment && !inAction && x != 0) {
			this.setType("3");
			this.increment = true;
		}
		if (this.increment && !inAction && x == 0) {
			this.setType(3);
			this.increment = false;
		}
		if (this.increment)
			increment();

	}
}
