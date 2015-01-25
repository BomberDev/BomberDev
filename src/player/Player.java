package player;

import entityConsole.drawable.CharacterDrawable;
import entityConsole.models.BomberCharacter;
import gameframework.base.ObservableValue;
import gameframework.drawing.Drawable;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.motion.MoveStrategy;
import gameframework.motion.overlapping.Overlappable;

public class Player extends BomberCharacter implements Drawable,Overlappable {
	ObservableValue<Integer> life;
	GameLevelDefaultImpl level;
	public Player(GameData data, MoveStrategy strategy,ObservableValue<Integer> life) {
		super(data, strategy);
		this.life=life;
	}

	@Override
	public void initDrawable(String filename,GameData data,int maxSpriteNumber){
		drawable=new CharacterDrawable(filename, data.getCanvas(),data.getConfiguration().getSpriteSize()*2 , maxSpriteNumber, this);
		data.getOverlapProcessor().addOverlappable(this);
	}
	
	public void setGameLevel(GameLevelDefaultImpl level){
		this.level=level;
	}
	
	@Override
	public void onTakingDamage() {
		this.drawable.animDying(data);
		this.life.setValue(this.life.getValue()-1);
		this.setPosition(1, 1);
		if(this.life.getValue()<=0&&this.level!=null)this.level.end();
	}
}
