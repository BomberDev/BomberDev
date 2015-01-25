package src.bomberdev.model;

import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;

import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.drawable.BlockDrawable;
import src.bomberdev.game.BomberUniverse;

public abstract class Block extends Tile implements MoveBlocker {

	public Block(Point position) {
		super(position);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(64, 64);
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
		this.drawable = (BlockDrawable) drawable;
	}

	@Override
	public BomberUniverse getUniverse() {
		return this.univ;
	}
}
