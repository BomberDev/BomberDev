package entityConsole.models;

import gameframework.game.GameEntity;
import java.awt.Point;

public interface BomberEntity extends GameEntity {

	// damage always 1, power is the length of fire
	/**
	 * Method called when the entity takes damage.
	 */
	void onTakingDamage();

	/**
	 * Gets the position of the entity.
	 * 
	 * @return A point describing the position of the entity in number of tiles.
	 */
	Point getPosition();
}
