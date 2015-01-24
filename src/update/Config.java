package update;

import gameframework.game.GameConfiguration;
import gameframework.motion.blocking.MoveBlockerRulesApplier;

public class Config extends GameConfiguration {
	public Config(){
		super();
	}
	public Config(int nbRows, int nbColumns, int spriteSize, int nbLives){
		super(nbRows,nbColumns,spriteSize,nbLives);
	}
	@Override
	public MoveBlockerRulesApplier createMoveBlockerRulesApplier() {
		return new GameBlockerRule();
	}
}
