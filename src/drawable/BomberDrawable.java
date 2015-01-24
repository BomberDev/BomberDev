package drawable;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import models.BomberEntity;

public abstract class BomberDrawable implements Drawable,GameEntity, Overlappable {

	protected final BomberEntity entity;
	protected SpriteManagerDefaultImpl spriteManager;
	protected boolean visible;
	protected int renderingSize;

	public BomberDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		this.entity = entity;
		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				filename, canvas), renderingSize, maxSpriteNumber);
		this.spriteManager.setTypes("right", "left", "down", "up");
		this.visible=true;
		this.renderingSize=renderingSize;
	}
	/**
	 * Set types like "right" "right" "down" "up"\n
	 * Appear in the first line of the picture should be the first to write
	 * @param s 4 types
	 */
	public void setTypes(String... s){
		this.spriteManager.setTypes(s);
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
	 *            <li>(0,-1) for up direction;</li>
	 *            </ul>
	 */
	public abstract void animIdle(Point direction);

	@Override
	public void draw(Graphics g) {
		if(visible)this.spriteManager.draw(g, this.entity.getPosition());
	}
	
	public int getRenderingSize(){
		return this.renderingSize;
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.renderingSize,this.renderingSize);
	}

	@Override
	public Point getPosition() {
		return this.entity.getPosition();
	}
}
