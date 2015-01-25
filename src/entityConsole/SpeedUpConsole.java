package entityConsole;

import java.awt.Point;

import entityConsole.drawable.ItemDrawable;
import entityConsole.models.BomberCharacter;
import entityConsole.models.PowerUpper;

public class SpeedUpConsole extends Console<PowerUpper, ItemDrawable> {

	public SpeedUpConsole(String imagefile, int maxSpriteNumber) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected PowerUpper creationEntity(int row, int column) {
		return new PowerUpper(new Point(renderingSize * row, renderingSize
				* column), data, this) {

			@Override
			public void PowerUp(BomberCharacter player) {
				player.incrimentSpeed();
			}
		};
	}

	@Override
	protected ItemDrawable creationDrawable(PowerUpper entity) {
		entity.createDrawable(this.imagefile, maxSpriteNumber);
		return entity.getDrawable();
	}

	@Override
	protected void deathPlay(PowerUpper entity) {
	}

}
