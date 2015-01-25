package other;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import player.Player;

import entityConsole.drawable.SelfDestructionDrawable;
import entityConsole.models.Bomb;
import entityConsole.models.BomberEntity;
import entityConsole.models.Block;
import gameframework.game.GameData;
import gameframework.game.GameEntity;

public enum Methods {
	East, South, Western, North;

	public static int DTPX(int x, Methods m) {
		if (m == East)
			return x + 1;
		else if (m == Western)
			return x - 1;
		else
			return x;
	}

	public static int DTPY(int y, Methods m) {
		if (m == South)
			return y + 1;
		else if (m == North)
			return y - 1;
		else
			return y;
	}

	public static Player getPlayerFramArea(GameData data, int cx, int cy) {
		Iterator<GameEntity> entitys = data.getUniverse()
				.getGameEntitiesIterator();
		for (GameEntity entity; entitys.hasNext();) {
			entity = entitys.next();
			// if(entity.equals(this))continue;
			if (entity instanceof Player) {// one who will be damaged
				Point p = ((BomberEntity) entity).getPosition();
				int dx = PTC(data, p.x);
				int dy = PTC(data, p.y);
				if (cx == dx && cy == dy) {
					return (Player) entity;
				}
			}
		}
		return null;
	}

	// we always ignore bomb itself ant his bomber bomb if exist
	public static boolean attackArea(GameData data, GameEntity ignore, int x,
			int y) {
		LinkedList<GameEntity> tmp = new LinkedList<GameEntity>();
		tmp.add(ignore);
		return attackArea(data, tmp, x, y);
	}

	public static boolean attackArea(GameData data, List<GameEntity> ignore,
			int x, int y) {
		Iterator<GameEntity> entitys = data.getUniverse()
				.getGameEntitiesIterator();
		Boolean res = true;
		for (GameEntity entity; entitys.hasNext();) {
			entity = entitys.next();
			if (ignore.contains(entity))
				continue;
			if (entity instanceof BomberEntity) {// one who will be damaged
				Point p = ((BomberEntity) entity).getPosition();
				int dx = PTC(data, p.x);
				int dy = PTC(data, p.y);
				int fx = PTC(data, x);
				int fy = PTC(data, y);
				if (fx == dx && fy == dy) {
					if (entity instanceof Block)
						res = false;
					if (entity instanceof Bomb)
						((Bomb) entity).onTakingDamage(ignore);
					else
						((BomberEntity) entity).onTakingDamage();
				}
			}
		}
		if (res)
			SelfDestructionDrawable.create("/Flame/Flame.png", data, 5, 5,
					new Point(x, y));
		return res;
	}

	public static void attackDirectionWithPower(Methods direction, int power,
			GameData data, List<GameEntity> ignore, int cx, int cy) {
		if (power == 0)
			return;
		if (attackArea(data, ignore, CTP(data, cx), CTP(data, cy)))
			attackDirectionWithPower(direction, power - 1, data, ignore,
					DTPX(cx, direction), DTPY(cy, direction));
	}

	public static void explode(int power, GameData data,
			List<GameEntity> ignore, int x, int y) {
		attackDirectionWithPower(Methods.East, power, data, ignore,
				PTC(data, x), PTC(data, y));
		attackDirectionWithPower(Methods.North, power, data, ignore,
				PTC(data, x), PTC(data, y));
		attackDirectionWithPower(Methods.South, power, data, ignore,
				PTC(data, x), PTC(data, y));
		attackDirectionWithPower(Methods.Western, power, data, ignore,
				PTC(data, x), PTC(data, y));
	}

	public static void explode(int power, GameData data, GameEntity ignore,
			int x, int y) {
		LinkedList<GameEntity> tmp = new LinkedList<GameEntity>();
		tmp.add(ignore);
		explode(power, data, tmp, x, y);
	}

	// position to Coordinate
	public static int PTC(GameData data, int position) {
		int size = data.getConfiguration().getSpriteSize();
		int x = Math.round(new Float(position) / new Float(size));
		return x;
	}

	private static int CTP(GameData data, int c) {
		int size = data.getConfiguration().getSpriteSize();
		return c * size;
	}
}
