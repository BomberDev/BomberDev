package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import src.bomberdev.model.BomberEntity;

public class SolidBlockDrawable extends BlockDrawable {

	protected final static String FILENAME = "/Resources/Graphics/Blocks/SolidBlock.png";

	public SolidBlockDrawable(BomberEntity entity, GameCanvas canvas) {
		super(FILENAME, entity, canvas);
	}

}
