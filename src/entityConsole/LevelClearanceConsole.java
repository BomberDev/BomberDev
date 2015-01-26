package entityConsole;

import java.awt.Point;

import entityConsole.drawable.ItemDrawable;
import entityConsole.models.LevelClearance;
import gameframework.game.GameLevelDefaultImpl;

public class LevelClearanceConsole extends Console<LevelClearance, ItemDrawable> {
	public LevelClearanceConsole(String imagefile, int maxSpriteNumber,GameLevelDefaultImpl level) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected LevelClearance creationEntity(int row, int column) {
		return new LevelClearance(new Point(renderingSize * row, renderingSize
				* column), data, this);
	}

	@Override
	protected ItemDrawable creationDrawable(LevelClearance entity) {
		entity.createDrawable(this.imagefile, maxSpriteNumber);
		return entity.getDrawable();
	}

	@Override
	protected void deathPlay(LevelClearance entity) {
	}

}
