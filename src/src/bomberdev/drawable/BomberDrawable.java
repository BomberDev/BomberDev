package src.bomberdev.drawable;

import gameframework.drawing.Drawable;
import gameframework.drawing.SpriteManager;

import java.awt.Graphics;
import java.awt.Point;

import src.bomberdev.model.BomberEntity;

public abstract class BomberDrawable implements Drawable {

	protected final BomberEntity entity;
	protected SpriteManager spriteManager;
	
	public BomberDrawable(SpriteManager manager, BomberEntity entity) {
		this.entity = entity;
	}
	
	/**
	 * The idle animation of the drawable.
	 * @param direction The direction of the drawable, described by a point:<br>
	 * <ul>
	 * 	<li>(1,0) for right direction;</li>
	 * 	<li>(-1,0) for left direction;</li>
	 * 	<li>(0,1) for down direction;</li>
	 * 	<li>(0,-1) for right direction;</li>
	 * </ul>
	 */
	public abstract void animIdle(Point direction);
	
	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, this.entity.getPosition());
	}
}
