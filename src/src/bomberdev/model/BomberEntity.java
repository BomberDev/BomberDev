package src.bomberdev.model;

import gameframework.game.GameEntity;

import java.awt.Point;

import src.bomberdev.drawable.BomberDrawable;
import src.bomberdev.game.BomberUniverse;

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
	
	/**
	 * Generates a drawable corresponding to the type of entity.
	 * @return A drawable of the entity.
	 */
	BomberDrawable draw();
	
	void setDrawable(BomberDrawable drawable);
	
	BomberUniverse getUniverse();
}
