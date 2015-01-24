package entityConsole;

import gameframework.drawing.Drawable;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;
import gameframework.motion.overlapping.Overlappable;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class Console<T extends GameEntity,D extends Drawable> implements GameEntity {

	protected LinkedList<T> entitys;
	protected HashMap<T, D> drawables;
	protected GameUniverse gameUniverse;
	//for creation drawable maxSpriteNumber, maxSpriteNumber int renderingSize
	
	protected String imagefile;
	protected GameData data;
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
			setdown();
		}
		this.gameUniverse=data.getUniverse();
		this.data=data;
		this.renderingSize=data.getConfiguration().getSpriteSize();
		this.gameUniverse.addGameEntity(this);
		for(GameEntity entity:entitys){
			this.gameUniverse.addGameEntity(entity);
			this.gameUniverse.addGameEntity((GameEntity)this.drawables.get(entity));
		}
	}
	
	public void setdown(){
		for(T entity:entitys){
			this.gameUniverse.removeGameEntity(entity);
			this.gameUniverse.removeGameEntity((GameEntity)this.drawables.get(entity));
		}
		this.gameUniverse.removeGameEntity(this);
		this.gameUniverse=null;
	}
	
	protected abstract T creationEntity(int row, int column);
	protected abstract D creationDrawable(T entity);
	protected abstract void deathPlay(T entity);
	
	public void createEntity(int row,int column){
		T entity = null;
		D drawable = null;
		try{
			entity = this.creationEntity(row, column);
			drawable = creationDrawable(entity);
		}catch(NullPointerException e){
			System.out.println("ERROR: NullPointerException\nforget to set Gamedata for console?\n at entityConsole.console");
			System.exit(0);
		}
		this.drawables.put(entity, drawable);
		this.entitys.add(entity);
		this.gameUniverse.addGameEntity(entity);
		this.gameUniverse.addGameEntity((GameEntity)drawable);
		if(drawable instanceof Overlappable)this.data.getOverlapProcessor().addOverlappable((Overlappable) drawable);
	}
	
	public void deleteEntity(T entity){
		D drawable = this.drawables.get(entity);
		this.gameUniverse.removeGameEntity((GameEntity)drawable);
		this.gameUniverse.removeGameEntity(entity);
		this.drawables.remove(entity);
		this.entitys.remove(entity);
		if(drawable instanceof Overlappable)this.data.getOverlapProcessor().removeOverlappable((Overlappable) drawable);
		deathPlay(entity);
	}
}
