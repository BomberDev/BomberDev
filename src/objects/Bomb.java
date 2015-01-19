package objects;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Bomb extends Thread implements GameEntity, MoveBlocker, Drawable {

	protected Point position;
	protected SpriteManager spriteManager;

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(100, 100);
	}

	public Bomb(GameCanvas canvas, int renderingSize, int maxSpriteNumber) {
		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				"/bomb.jpg", canvas), renderingSize, maxSpriteNumber);
	}

	@Override
	public void draw(Graphics g) {
		spriteManager.draw(g, position);
	}

}
