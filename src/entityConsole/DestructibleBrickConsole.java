package entityConsole;

import java.awt.Point;

import entityConsole.drawable.BlockDrawable;
import entityConsole.drawable.SelfDestructionDrawable;
import entityConsole.models.Block;

public class DestructibleBrickConsole extends Console<Block, BlockDrawable> {

	public DestructibleBrickConsole(String imagefile, int maxSpriteNumber) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected Block creationEntity(int row, int column) {
		return new Block(new Point(renderingSize * row, renderingSize * column)) {
			@Override
			public void onTakingDamage() {
				DestructibleBrickConsole.this.deleteEntity(this);
			}
		};
	}

	@Override
	protected BlockDrawable creationDrawable(Block entity) {
		return new BlockDrawable(imagefile, data.getCanvas(), renderingSize,
				maxSpriteNumber, entity);
	}

	@Override
	protected void deathPlay(Block entity) {
		SelfDestructionDrawable.create("/Flame/Flame.png", data, 5, 5, entity);
	}

}
