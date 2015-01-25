package entityConsole;

import java.awt.Point;

import entityConsole.models.*;
import entityConsole.drawable.BombDrawable;
import entityConsole.drawable.SelfDestructionDrawable;
import entityConsole.models.Bomb;

public class BombConsole extends Console<Bomb, BombDrawable> {
	private BomberCharacter owner;
	public BombConsole(String imagefile, int maxSpriteNumber,BomberCharacter owner) {
		super(imagefile, maxSpriteNumber);
		this.owner=owner;
	}

	@Override
	protected Bomb creationEntity(int row, int column) {
		
		int s = data.getConfiguration().getSpriteSize();
		int x = Math.round(new Float(row)/new Float(s));
		int y = Math.round(new Float(column)/new Float(s));
		return new Bomb(owner, new Point(x*s,y*s),this.data);
	}

	@Override
	protected BombDrawable creationDrawable(Bomb entity) {
		BombDrawable res = null;
		try{
			entity.createDrawable(imagefile, data.getCanvas(), renderingSize, maxSpriteNumber);
			res = entity.getDrawable();
		}catch(NullPointerException e){
			System.out.println("ERROR: "+"NullPointerException : "+e.getLocalizedMessage()+"\n -gameData havn't set into Console?\nat entityConsole.BomberConsole\nat entityConsole.models.BomberCharacter");
			System.exit(0);
		}
		return res;
	}

	@Override
	protected void deathPlay(Bomb entity) {
		SelfDestructionDrawable.create("/22.png", data, 1, 3, entity);
	}



}
