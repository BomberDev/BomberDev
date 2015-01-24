package entityConsole;

import java.awt.Point;

import entityConsole.drawable.BrickDrawable;
import entityConsole.models.Brick;


public class IndestructibleBrickConsole extends Console<Brick,BrickDrawable>{

	
	public IndestructibleBrickConsole(String imagefile, int maxSpriteNumber) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected Brick creationEntity(int row, int column) {
		return new Brick(new Point(renderingSize*row,renderingSize*column)){
			@Override
			public void onTakingDamage(int damage) {			}	
		};
	}

	@Override
	protected BrickDrawable creationDrawable(Brick entity) {
		return new BrickDrawable(imagefile, data.getCanvas(), renderingSize, maxSpriteNumber, entity);
	}

}
