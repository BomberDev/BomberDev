package src.bomberdev.model;

import gameframework.drawing.GameCanvas;

import java.awt.Point;

import src.bomberdev.drawable.BackgroundTileDrawable;
import src.bomberdev.drawable.BomberDrawable;

public class BackgroundTile extends Tile {

	public BackgroundTile(Point position) {
		super(position);
	}

	@Override
	public BomberDrawable draw(GameCanvas canvas) {
		return new BackgroundTileDrawable(this, canvas);
	}

	@Override
	public void onTakingDamage(int damage) {
		// TODO Auto-generated method stub
		
	}

}
