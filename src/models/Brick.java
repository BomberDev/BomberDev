package models;

import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;

import drawable.BrickDrawable;

public abstract class Brick implements BomberEntity, MoveBlocker {

	protected final Point position;
	protected BrickDrawable drawable;

	public Brick(Point position) {
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

}
