package entityConsole.models;

import other.Methods;
import entityConsole.Console;
import entityConsole.MonsterConsole;
import entityConsole.drawable.BomberDrawable;
import entityConsole.drawable.CharacterDrawable;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;

public class Monster extends BomberCharacter  {
	
	private int life; 
	Console<Monster, CharacterDrawable> s;
	public Monster(GameData data, MoveStrategy strategy,MonsterConsole monsterConsole) {
		super(data, strategy);
		this.life = 1;
		this.s=monsterConsole;
	}
	
	public Monster(int bombPower, int healthPoints, int stockBombs, int speed,
			GameData data, MoveStrategy strategy) {
		super(bombPower, healthPoints, stockBombs, speed, data, strategy);
	}

	public int getLife(){
		return this.life;
	}
	
	
	@Override
	public void oneStepMoveAddedBehavior(){
		Methods.attackArea(data, this, this.getPosition().x, this.getPosition().y);
	}
	
	public void onTakingDamage(){
		life --;
		if (life <= 0) {
			this.s.deleteEntity(this);
		}
	}

	
}
