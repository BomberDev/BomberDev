package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import src.bomberdev.model.BomberEntity;

public class ExplosionDrawable extends BomberDrawable {

	public ExplosionDrawable(String filename, BomberEntity entity, GameCanvas canvas) {
		super(filename, entity, canvas);
	}

	@Override
	public void animIdle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSpriteSize() {
		// TODO Auto-generated method stub
		return 0;
	}


}
