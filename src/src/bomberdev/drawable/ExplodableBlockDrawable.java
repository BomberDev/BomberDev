package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import src.bomberdev.model.BomberEntity;

public class ExplodableBlockDrawable extends BlockDrawable {

	protected final static String FILENAME;

	static {
		FILENAME = "/Resources/Graphics/Blocks/ExplodableBlock.png";
	}
	
	public ExplodableBlockDrawable(BomberEntity entity, GameCanvas canvas) {
		super(FILENAME, entity, canvas);
	}

}
