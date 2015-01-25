package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import src.bomberdev.model.BomberEntity;

public class BombDrawable extends BomberDrawable {
	
	protected static String filename = "/Resources/Graphics/Blocks/Bomb.png";
	
	public BombDrawable(BomberEntity entity, GameCanvas canvas) {
		super(filename, entity, canvas);
	}

	@Override
	public void animIdle() {
		// TODO Auto-generated method stub
	}

	public void animExplode() {
		// TODO implement
	}

	@Override
	public int getSpriteSize() {
		// TODO Auto-generated method stub
		return 0;
	}
}
