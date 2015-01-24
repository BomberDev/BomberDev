package entityConsole.drawable;

import entityConsole.models.BomberEntity;
import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class BomberDrawable implements Drawable,GameEntity {

	protected final BomberEntity entity;
	protected SpriteManagerDefaultImpl spriteManager;
	protected int renderingSize;

	public BomberDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		this.entity = entity;
		spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				filename, canvas), renderingSize, maxSpriteNumber);
		this.spriteManager.setTypes("right", "left", "down", "up");
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
		this.spriteManager.draw(g, this.entity.getPosition());
	}
	
	public int getRenderingSize(){
		return this.renderingSize;
	}
	
	
	public Rectangle getBoundingBox() {
		Dimension dimension = new Dimension();
		dimension.setSize(this.renderingSize, this.renderingSize);
		return new Rectangle(this.getPosition(),dimension);
	}

	
	public Point getPosition() {
		return this.entity.getPosition();
	}
	
	public SpriteManager getSpriteManager(){
		return this.spriteManager;
	}
	
	public void increment(){
		this.spriteManager.increment();
	}
}
