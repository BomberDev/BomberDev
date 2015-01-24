package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;

import java.awt.Point;

import src.bomberdev.model.BomberEntity;

public class BlockDrawable extends BomberDrawable {

	public BlockDrawable(String filename, BomberEntity entity, GameCanvas canvas) {
		super(filename, entity, canvas);
	}

	@Override
	public void animIdle() {
		// TODO Auto-generated method stub
		
	}

	public void animDestroy() {
		// TODO Implement
	}
}
