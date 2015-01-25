package src.bomberdev.model;

import gameframework.motion.overlapping.Overlappable;

import java.awt.Point;

import src.bomberdev.drawable.BlockDrawable;
import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.game.BomberUniverse;

public abstract class Tile implements BomberEntity, Overlappable {

	protected BomberUniverse univ;
	protected final Point position;
	protected BlockDrawable drawable;

	public Tile(Point position) {
		this.position = new Point(position);
	}

	@Override
	public Point getPosition() {
		return new Point(this.position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
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
