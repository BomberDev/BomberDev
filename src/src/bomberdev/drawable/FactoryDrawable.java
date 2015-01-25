package src.bomberdev.drawable;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;

import java.util.ArrayList;
import java.util.Iterator;

import src.bomberdev.model.BomberEntity;

public class FactoryDrawable {
	
	/**
	 * Creates a corresponding {@link BomberDrawable} for each of the {@link BomberEntity} found
	 * in the {@link GameUniverse}'s list of entities, and associate it with the entity.
	 * @param data The data from where the drawables will be created.
	 */
	public static void createDrawablesForAllEntities(GameData data) {
		GameCanvas canvas = data.getCanvas();
		GameUniverse univ = data.getUniverse();
		Iterator<GameEntity> it = univ.getGameEntitiesIterator();
		
		/* We need a result list, or the GameUniverse's list of entities
		 * will be modified while we iterate over it.
		 */
		ArrayList<BomberDrawable> list = new ArrayList<BomberDrawable>();
		
		while(it.hasNext()) {
			// Create the drawable
			BomberEntity ent = (BomberEntity) it.next();
			BomberDrawable draw = ent.draw(canvas);
			
			// Set it to the entity and add it to the result list
			ent.setDrawable(draw);
			list.add(draw);
		}
		
		// Now, add the whole list to the GameUniverse
		for(BomberDrawable draw : list) {
			univ.addGameEntity(draw);
		}
	}
	
}
