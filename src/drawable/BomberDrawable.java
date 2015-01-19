package drawable;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;

import java.awt.Graphics;
import java.awt.Point;

import models.BomberEntity;

public abstract class BomberDrawable implements Drawable {

	protected final BomberEntity entity;
	protected SpriteManagerDefaultImpl spriteManager;

	public BomberDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		this.entity = entity;
		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				filename, canvas), renderingSize, maxSpriteNumber);
		this.spriteManager.setTypes("right", "left", "down", "up");
	}

	/**
	 * The idle animation of the drawable.
	 * 
	 * @param direction
	 *            The direction of the drawable, described by a point:<br>
	 *            <ul>
	 *            <li>(1,0) for right direction;</li>
	 *            <li>(-1,0) for left direction;</li>
	 *            <li>(0,1) for down direction;</li>
	 *            <li>(0,-1) for right direction;</li>
	 *            </ul>
	 */
	public abstract void animIdle(Point direction);

	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, this.entity.getPosition());
	}
}
