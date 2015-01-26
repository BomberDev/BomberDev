package player;

import entityConsole.drawable.CharacterDrawable;
import entityConsole.models.BomberCharacter;
import gameframework.base.ObservableValue;
import gameframework.drawing.Drawable;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.overlapping.Overlappable;

public class Player extends BomberCharacter implements Drawable, Overlappable {
	ObservableValue<Integer> life;
	int noDamage=0;
	public Player(GameData data, MoveStrategy strategy,
			ObservableValue<Integer> life) {
		super(data, strategy);
		this.life = life;
	}


	@Override
	public void initDrawable(String filename, GameData data, int maxSpriteNumber) {
		drawable = new CharacterDrawable(filename, data.getCanvas(), data
				.getConfiguration().getSpriteSize() * 2, maxSpriteNumber, this);
		data.getOverlapProcessor().addOverlappable(this);
	}


	@Override
	public void onTakingDamage() {
		if(this.noDamage>0)return;
		this.drawable.animDying(data);
		this.life.setValue(this.life.getValue() - 1);
		this.setPosition(1, 1);
		this.noDamage=10;




	}

	@Override
	public void oneStepMoveAddedBehavior() {
		super.oneStepMoveAddedBehavior();
		if(this.noDamage>0)this.noDamage--;
		if(this.data.getLife().getValue()<=0)this.data.getEndOfGame().setValue(true);
	}
}

