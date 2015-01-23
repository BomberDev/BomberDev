package src.bomberdev.model;

import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;

import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.drawable.BrickDrawable;
import src.bomberdev.game.BomberUniverse;

public abstract class Block implements BomberEntity, MoveBlocker {

	protected BomberUniverse univ;
	protected final Point position;
	protected BrickDrawable drawable;
	
	public Block(BomberUniverse univ, Point position) {
		this.univ = univ;
		this.position = position;
	}
	
	public Block(Point position) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (drawable == null) {
			if (other.drawable != null)
				return false;
		} else if (!drawable.equals(other.drawable))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	public void setDrawable(BomberDrawable drawable) {
		this.drawable = (BrickDrawable) drawable;
	}
	
	@Override
	public BomberUniverse getUniverse() {
		return this.univ;
	}
}
