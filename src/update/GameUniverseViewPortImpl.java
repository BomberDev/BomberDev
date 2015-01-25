package update;

import java.net.URL;

import gameframework.drawing.BackgroundImage;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class GameUniverseViewPortImpl extends GameUniverseViewPortDefaultImpl{
	public void setBackgroundImage(String filename){
		this.background=new BackgroundImage(backgroundImage(filename), getCanvas());
	}
	
	public void setGameData(GameData data,String backgroundImageFilename){
		this.setGameData(data);
		this.setBackgroundImage(backgroundImageFilename);
	}
	@Override
	protected URL backgroundImage() {
		return backgroundImage("/Blocks/BackgroundTile1915.png");
	}
}
