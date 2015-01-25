package entityConsole.models;

import java.awt.Point;
import java.awt.Rectangle;

import other.Methods;

import entityConsole.Console;
import entityConsole.drawable.ItemsDrawable;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

public abstract class PowerUper implements BomberEntity,Movable {

	protected GameData data;
	protected Point position;
	protected Console<PowerUper, ItemsDrawable> console;
	private ItemsDrawable drawable;

	public PowerUper(Point position, GameData data,Console<PowerUper, ItemsDrawable> console) {
		this.position = position;
		this.data=data;
		this.console=console;
	}
	public void createDrawable(String filename,int maxSpriteNumber){
		this.createDrawable(filename, data.getCanvas(), data.getConfiguration().getSpriteSize(), maxSpriteNumber);
	}
	
	public void createDrawable(String filename, GameCanvas canvas, int renderingSize,
			int maxSpriteNumber){
		this.drawable=new ItemsDrawable(filename, canvas, renderingSize, maxSpriteNumber, this);
	}

	public ItemsDrawable getDrawable(){
		return this.drawable;
	}
	public abstract void PowerUp(BomberCharacter player);
	
	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public Rectangle getBoundingBox() {
		return this.drawable.getBoundingBox();
	}

	@Override
	public SpeedVector getSpeedVector() {
		return SpeedVector.createNullVector();
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		
	}

	@Override
	public void oneStepMove() {
		BomberCharacter character = Methods.getPlayerFramArea(data, Methods.PTC(data, this.position.x), Methods.PTC(data, this.position.y));
		if(character!=null){
			this.PowerUp(character);
			this.console.deleteEntity(this);
		}
	}

	@Override
	public void onTakingDamage() {
		this.console.deleteEntity(this);
	}

}
