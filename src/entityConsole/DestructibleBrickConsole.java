package entityConsole;

import java.awt.Point;

import entityConsole.drawable.BrickDrawable;
import entityConsole.models.Brick;


public class DestructibleBrickConsole extends Console<Brick,BrickDrawable>{

	
	public DestructibleBrickConsole(String imagefile, int maxSpriteNumber) {
		super(imagefile, maxSpriteNumber);
	}

	@Override
	protected Brick creationEntity(int row, int column) {
		return new Brick(new Point(renderingSize*row,renderingSize*column)){
			@Override
			public void onTakingDamage(int damage) {
				if(damage>0)DestructibleBrickConsole.this.deleteEntity(this);
			}	
		};
	}

	@Override
	protected BrickDrawable creationDrawable(Brick entity) {
		return new BrickDrawable(imagefile, canvas, renderingSize, maxSpriteNumber, entity);
	}

}
