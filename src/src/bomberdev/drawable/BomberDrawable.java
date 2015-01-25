package src.bomberdev.drawable;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;

import java.awt.Graphics;
import java.awt.Point;

import src.bomberdev.model.BomberEntity;

public abstract class BomberDrawable extends DrawableImage implements
		GameEntity {
	
	public static final int TILE_SPRITE_SIZE;

	protected final BomberEntity entity;
	protected SpriteManagerDefaultImpl manager;
	
	static {
		TILE_SPRITE_SIZE = 64;
	}
	
	public BomberDrawable(String filename, BomberEntity entity,
			GameCanvas canvas) {
		super(filename, canvas);
		this.entity = entity;
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
	public abstract void animIdle();

	public int getSpriteSize() {
		return TILE_SPRITE_SIZE;
	}
	
	public Point computePosition() {
		Point pos = this.entity.getPosition();
		int size = getSpriteSize();
		pos.setLocation(pos.getX() * size, pos.getY() * size);
		
		return pos;
	}
	
	@Override
	public void draw(Graphics g) {
		Point p = computePosition();
		this.manager.draw(g, p);
	}
}
