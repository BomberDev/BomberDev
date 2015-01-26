package entityConsole;

import entityConsole.models.*;
import entityConsole.drawable.CharacterDrawable;
import entityConsole.drawable.SelfDestructionDrawable;
import gameframework.motion.MoveStrategyRandom;

public class MonsterConsole extends Console<Monster, CharacterDrawable> {

	public MonsterConsole(String imagefile, int maxSpriteNumber) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected Monster creationEntity(int row, int column) {
		Monster res = new Monster(data, new MoveStrategyRandom(), this);
		res.setPosition(row, column);
		return res;
		
		
	}

	@Override
	protected CharacterDrawable creationDrawable(Monster entity) {
		CharacterDrawable res = null;
		try {
			entity.initDrawable(imagefile, data, maxSpriteNumber);
			res = entity.getDrawable();
		} catch (NullPointerException e) {
			System.out
					.println("ERROR: "
							+ "NullPointerException : "
							+ e.getLocalizedMessage()
							+ "\n -gameData havn't set into Console?\nat entityConsole.BomberConsole\nat entityConsole.models.BomberCharacter");
			System.exit(0);
		}
		return res;
	}

	@Override
	protected void deathPlay(Monster entity) {
		SelfDestructionDrawable.create("/22.png", data, 1, 3, entity);
	}

}
