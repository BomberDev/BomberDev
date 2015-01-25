package entityConsole.drawable;

import entityConsole.models.BomberEntity;
import entityConsole.models.Block;
import gameframework.drawing.GameCanvas;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Point;

public class BlockDrawable extends BomberDrawable implements MoveBlocker,Overlappable  {

	public BlockDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas, renderingSize, maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		this.spriteManager.setType("left");
	}

	public void animDestroy() {
		((Block)entity).onTakingDamage();
	}

}
