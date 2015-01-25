package entityConsole.drawable;

import entityConsole.models.BomberEntity;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class CharacterDrawable extends BomberDrawable {

	public CharacterDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber, BomberEntity entity) {
		super(filename, canvas,renderingSize , maxSpriteNumber, entity);
	}

	@Override
	public void animIdle(Point direction) {
		int x = direction.x;
		int y = direction.y;
		if(x<0)this.spriteManager.setType("left");
		else if(x>0)this.spriteManager.setType("right");
		else if(y<0)this.spriteManager.setType("up");
		else if(y>0)this.spriteManager.setType("down");
	}
	
	@Override
	public void draw(Graphics g) {
		Point imagePosition = (Point) this.entity.getPosition().clone();
		imagePosition.x-=this.getRenderingSize()/4;
		imagePosition.y-=this.getRenderingSize()/2;
		this.spriteManager.draw(g, imagePosition);
	}
	@Override
	public Rectangle getBoundingBox() {
		Dimension dimension = new Dimension();
		dimension.setSize(this.getRenderingSize()/2, this.getRenderingSize()/2);
		return new Rectangle(this.getPosition(),dimension);
	}
	
	public void reset(){
		this.spriteManager.reset();
	}
	
	public void animMoving(Point direction) {
		this.spriteManager.increment();
	}

	public void animPlanting() {
		//It's better that we have a such picture...
	}

	public void animDying(GameData data) {
		SelfDestructionDrawable.create("/Flame/Flame.png", data, 5, 5, entity);
	}
}
