package character;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.Movable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import objects.Bomb;

public class Player extends GameMovable implements Movable, Drawable,
		GameEntity, MoveBlocker {

	protected SpriteManager spriteManager;
	protected MoveStrategy strategy;
	protected String name;
	protected boolean alive = true;
	protected ArrayList<Bomb> bombStack = new ArrayList<Bomb>();

	public Player(String name, MoveStrategy moveStrategy, String filename,
			GameCanvas canvas, int renderingSize, int maxSpriteNumber,
			Point startPosition) {

		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				filename, canvas), renderingSize, maxSpriteNumber);
		this.name = name;
		this.strategy = moveStrategy;
		this.speedVector = moveStrategy.getSpeedVector();
		this.setPosition(startPosition);
		// bombStack.add(new Bomb(canvas, maxSpriteNumber, maxSpriteNumber));
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(100, 100);
	}

	public void increment() {
		this.spriteManager.increment();
	}

	public void die() {
		alive = false;
	}

	public boolean isAlive() {
		return alive;
	}

	@Override
	public void draw(Graphics g) {
		spriteManager.draw(g, getPosition());
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub

	}
}
