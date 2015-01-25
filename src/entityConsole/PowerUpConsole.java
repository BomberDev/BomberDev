package entityConsole;

import java.awt.Point;

import entityConsole.drawable.ItemsDrawable;
import entityConsole.models.BomberCharacter;
import entityConsole.models.PowerUper;

public class PowerUpConsole extends Console<PowerUper, ItemsDrawable> {

	public PowerUpConsole(String imagefile, int maxSpriteNumber) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected PowerUper creationEntity(int row, int column) {
		return new PowerUper(new Point(renderingSize*row,renderingSize*column), data, this){

			@Override
			public void PowerUp(BomberCharacter player) {
				player.imcrementPower();
			}};
	}

	@Override
	protected ItemsDrawable creationDrawable(PowerUper entity) {
		entity.createDrawable(this.imagefile, maxSpriteNumber);
		return entity.getDrawable();
	}

	@Override
	protected void deathPlay(PowerUper entity) {
	}

}
