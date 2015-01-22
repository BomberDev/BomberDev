package src.bomberdev.drawable;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;

import java.awt.Graphics;
import java.awt.Point;

import src.bomberdev.model.BomberEntity;

public abstract class BomberDrawable extends DrawableImage implements GameEntity {

	protected final BomberEntity entity;
	protected SpriteManagerDefaultImpl manager;
	
	public BomberDrawable(String filename, BomberEntity entity, GameCanvas canvas) {
		super(filename, canvas);
		this.entity = entity;
		this.manager = new SpriteManagerDefaultImpl(this, 128, 8);
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

	@Override
	public void draw(Graphics g) {
		this.manager.draw(g, this.entity.getPosition());
	}
}
