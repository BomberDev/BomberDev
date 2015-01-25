package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import src.bomberdev.model.BomberEntity;

public class BackgroundTileDrawable extends BlockDrawable {

	protected final static String FILENAME = "/Resources/Graphics/Blocks/BackgroundTile.png";

	public BackgroundTileDrawable(BomberEntity entity, GameCanvas canvas) {
		super(FILENAME, entity, canvas);
	}

}
