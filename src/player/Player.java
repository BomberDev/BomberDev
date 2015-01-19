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
import java.awt.Point;
import java.awt.Rectangle;

public class Player extends GameMovable implements GameEntity, Drawable,
		Movable, ObjectWithBoundedBox {

	protected SpriteManagerDefaultImpl spriteManager;
	protected boolean increment = false;
	protected boolean inAction;

	public Player(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, MoveStrategy strategy) {
		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				filename, canvas), renderingSize, maxSpriteNumber);
		this.spriteManager.setTypes("right", "left", "down", "up");
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
		this.spriteManager.increment();
	}


	public void setType(String type) {
		this.spriteManager.setType(type);
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
		Point p = this.speedVector.getDirection();
		if (!inAction && x != 0) {
			if(p.x>0)this.setType("right");
			else if(p.x<0)this.setType("left");
			else if(p.y>0)this.setType("down");
			else this.setType("up");
			this.increment = true;
		}
		if (this.increment && !inAction && x == 0) {
			this.spriteManager.reset();
			this.increment = false;
		}
		if (this.increment)
			increment();

	}
}
