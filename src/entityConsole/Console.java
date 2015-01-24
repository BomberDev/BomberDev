package entityConsole;

import gameframework.drawing.Drawable;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class Console<T extends GameEntity,D extends Drawable> {

	protected LinkedList<T> entitys;
	protected HashMap<T, D> drawables;
	protected GameUniverse gameUniverse;
	//for creation drawable maxSpriteNumber, maxSpriteNumber int renderingSize
	
	protected String imagefile;
	protected GameCanvas canvas;
	protected int renderingSize;
	protected int maxSpriteNumber;
	
	public Console(String imagefile,int maxSpriteNumber){
		this.entitys=new LinkedList<T>();
		this.drawables= new HashMap<T, D> ();
		this.imagefile=imagefile;
		this.maxSpriteNumber=maxSpriteNumber;
	}
	
	public void setGameData(GameData data){
		if(this.gameUniverse!=null){
			for(T entity:entitys){
				this.gameUniverse.removeGameEntity(entity);
				this.gameUniverse.removeGameEntity((GameEntity)this.drawables.get(entity));
			}
		}
		this.gameUniverse=data.getUniverse();
		this.canvas=data.getCanvas();
		this.renderingSize=data.getConfiguration().getSpriteSize();
		for(GameEntity entity:entitys){
			this.gameUniverse.addGameEntity(entity);
			this.gameUniverse.addGameEntity((GameEntity)this.drawables.get(entity));
		}
	}
	
	protected abstract T creationEntity(int row, int column);
	protected abstract D creationDrawable(T entity);
	
	public void createEntity(int row,int column){
		T entity = this.creationEntity(row, column);
		D drawable = creationDrawable(entity);
		this.drawables.put(entity, drawable);
		this.entitys.add(entity);
		this.gameUniverse.addGameEntity(entity);
		this.gameUniverse.addGameEntity((GameEntity)drawable);
	}
	
	public void deleteEntity(T entity){
		D drawable = this.drawables.get(entity);
		this.gameUniverse.removeGameEntity((GameEntity)drawable);
		this.gameUniverse.removeGameEntity(entity);
		this.drawables.remove(entity);
		this.entitys.remove(entity);
	}
}
