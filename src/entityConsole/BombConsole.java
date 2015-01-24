package entityConsole;

import java.awt.Point;
import entityConsole.models.*;
import entityConsole.drawable.BombDrawable;
import entityConsole.models.Bomb;

public class BombConsole extends Console<Bomb, BombDrawable> {
	private BomberCharacter owner;
	public BombConsole(String imagefile, int maxSpriteNumber,BomberCharacter owner) {
		super(imagefile, maxSpriteNumber);
		this.owner=owner;
	}

	@Override
	protected Bomb creationEntity(int row, int column) {
		int x = Math.getExponent(new Float(row)/new Float(this.renderingSize));
		int y = Math.getExponent(new Float(column)/new Float(this.renderingSize));
		return new Bomb(owner, new Point(x*this.renderingSize,y*this.renderingSize), this.gameUniverse);
	}

	@Override
	protected BombDrawable creationDrawable(Bomb entity) {
		return new BombDrawable(imagefile, canvas, renderingSize, maxSpriteNumber, entity);
	}



}
