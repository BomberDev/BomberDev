package player;

import entityConsole.drawable.CharacterDrawable;
import entityConsole.models.BomberCharacter;
import gameframework.drawing.Drawable;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.overlapping.Overlappable;

public class Player extends BomberCharacter implements Drawable,Overlappable {

	public Player(GameData data, MoveStrategy strategy) {
		super(data, strategy);
	}

	@Override
	public void initDrawable(String filename,GameData data,int maxSpriteNumber){
		drawable=new CharacterDrawable(filename, data.getCanvas(),data.getConfiguration().getSpriteSize()*2 , maxSpriteNumber, this);
		data.getOverlapProcessor().addOverlappable(this);
	}
}
