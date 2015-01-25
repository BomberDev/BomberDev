package entityConsole;

import java.awt.Point;

import entityConsole.drawable.BrickDrawable;
import entityConsole.drawable.SelfDestructionDrawable;
import entityConsole.models.Brick;

public class DestructibleBrickConsole extends Console<Brick, BrickDrawable> {

	public DestructibleBrickConsole(String imagefile, int maxSpriteNumber) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected Brick creationEntity(int row, int column) {
		return new Brick(new Point(renderingSize * row, renderingSize * column)) {
			@Override
			public void onTakingDamage() {
				DestructibleBrickConsole.this.deleteEntity(this);
			}
		};
	}

	@Override
	protected BrickDrawable creationDrawable(Brick entity) {
		return new BrickDrawable(imagefile, data.getCanvas(), renderingSize,
				maxSpriteNumber, entity);
	}

	@Override
	protected void deathPlay(Brick entity) {
		SelfDestructionDrawable.create("/Flame/Flame.png", data, 5, 5, entity);
	}

}
