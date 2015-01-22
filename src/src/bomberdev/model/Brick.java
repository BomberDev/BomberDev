package src.bomberdev.model;

import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;

import src.bomberdev.drawable.BombDrawable;
import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.drawable.BrickDrawable;
import src.bomberdev.game.BomberUniverse;

public abstract class Brick implements BomberEntity, MoveBlocker {

	protected BomberUniverse univ;
	protected final Point position;
	protected BrickDrawable drawable;
	
	public Brick(BomberUniverse univ, Point position) {
		this.univ = univ;
		this.position = position;
	}
	
	@Override
	public Point getPosition() {
		return this.position;
	}
	
	@Override
	public Rectangle getBoundingBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDrawable(BomberDrawable drawable) {
		this.drawable = (BrickDrawable) drawable;
	}
	
	@Override
	public BomberUniverse getUniverse() {
		return this.univ;
	}
}
