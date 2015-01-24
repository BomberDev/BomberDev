package entityConsole.models;

import gameframework.game.GameEntity;
import java.awt.Point;

public interface BomberEntity extends GameEntity {

	/**
	 * Method called when the entity takes damage.
	 * @param damage The number of damage taken.
	 */
	void onTakingDamage(int damage);
	
	/**
	 * Gets the position of the entity.
	 * @return A point describing the position of the entity in number of tiles.
	 */
	Point getPosition();
}
