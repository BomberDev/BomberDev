package src.bomberdev.game;

import gameframework.game.GameEntity;
import gameframework.game.GameUniverseDefaultImpl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import src.bomberdev.model.Bomb;
import src.bomberdev.model.BomberEntity;

public class BomberUniverse extends GameUniverseDefaultImpl {

	public synchronized void explosionOccuring(Bomb bomb) {
		Point pos = bomb.getPosition();
		int power = bomb.getFirePower();
		int areapwr = bomb.getAreaPower();
		List<Point> area = getExplosionArea(pos, areapwr);
		
		// Check all entities in area to make them take damage
		for (GameEntity ent : this.gameEntities) {
			BomberEntity bent = (BomberEntity) ent;
			
			if(area.contains(bent.getPosition())) {
				bent.onTakingDamage(power);
			}
		}
	}
	
	protected List<Point> getExplosionArea(Point pos, int power) {
		List<Point> list = new ArrayList<Point>();
		
		for(int i = -power; i <= power; i++) {
			list.add(new Point((int) pos.getX() + i, (int) pos.getY()));
			list.add(new Point((int) pos.getX(), (int) pos.getY() + i));
		}
		
		return list;
	}
}
