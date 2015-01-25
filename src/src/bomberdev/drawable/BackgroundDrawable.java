package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import src.bomberdev.model.BomberEntity;

public class BackgroundDrawable extends BlockDrawable {

	protected final static String FILENAME = "/Resources/Graphics/Blocks/BackgroundTile.png";

	public BackgroundDrawable(BomberEntity entity, GameCanvas canvas) {
		super(FILENAME, entity, canvas);
	}

}
