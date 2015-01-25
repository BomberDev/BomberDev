package entityConsole;

import entityConsole.drawable.BomberDrawable;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;
import gameframework.motion.overlapping.Overlappable;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * A console is a console for a same type of an entity drawable. The entitys
 * created by this method is safe because this will do everything even if you
 * want to change your gamedata.
 * 
 * @author Xingxue
 *
 * @param <T>
 *            GameEntity
 * @param <D>
 *            {@link gameframework.drawing.Drawable}, may be
 *            {@link gameframework.motion.blocking.MoveBlocker} but always
 *            display for the above GameEntity
 */
public abstract class Console<T extends GameEntity, D extends BomberDrawable>
		implements GameEntity {

	protected LinkedList<T> entitys;
	protected HashMap<T, D> drawables;
	protected GameUniverse gameUniverse;
	// for creation drawable maxSpriteNumber, maxSpriteNumber int renderingSize

	protected String imagefile;
	protected GameData data;
	protected int renderingSize;
	protected int maxSpriteNumber;

	public Console(String imagefile, int maxSpriteNumber) {
		this.entitys = new LinkedList<T>();
		this.drawables = new HashMap<T, D>();
		this.imagefile = imagefile;
		this.maxSpriteNumber = maxSpriteNumber;
	}

	public void setGameData(GameData data) {
		if (this.gameUniverse != null) {
			setdown();
		}
		this.gameUniverse = data.getUniverse();
		this.data = data;
		this.renderingSize = data.getConfiguration().getSpriteSize();
		this.gameUniverse.addGameEntity(this);
		for (GameEntity entity : entitys) {
			this.gameUniverse.addGameEntity(entity);
			this.gameUniverse.addGameEntity((GameEntity) this.drawables
					.get(entity));
		}
	}

	/**
	 * remove all entity for the gamedata. with this method the console will be
	 * free
	 */
	public void setdown() {
		for (T entity : entitys) {
			this.gameUniverse.removeGameEntity(entity);
			this.gameUniverse.removeGameEntity((GameEntity) this.drawables
					.get(entity));
		}
		this.gameUniverse.removeGameEntity(this);
		this.gameUniverse = null;
	}

	protected abstract T creationEntity(int row, int column);

	protected abstract D creationDrawable(T entity);

	/**
	 * SelfDestructionDrawable.create("/Flame/Flame.png", data, 5, 5, entity);
	 * is a good example for this method. Be careful, the Death drawable entity
	 * should be deleted it-self.
	 * 
	 * @param entity
	 */
	protected abstract void deathPlay(T entity);

	public void createEntity(int row, int column) {
		T entity = null;
		D drawable = null;
		try {
			entity = this.creationEntity(row, column);
			drawable = creationDrawable(entity);
		} catch (NullPointerException e) {
			System.out
					.println("ERROR: NullPointerException\nforget to set Gamedata for console?\n at entityConsole.console");
			System.exit(0);
		}
		this.drawables.put(entity, drawable);
		this.entitys.add(entity);
		this.gameUniverse.addGameEntity(entity);
		this.gameUniverse.addGameEntity((GameEntity) drawable);
		if (drawable instanceof Overlappable)
			this.data.getOverlapProcessor().addOverlappable(
					(Overlappable) drawable);
	}

	public void deleteEntity(T entity) {
		if (!this.drawables.containsKey(entity))
			return;
		D drawable = this.drawables.get(entity);
		this.gameUniverse.removeGameEntity((GameEntity) drawable);
		this.gameUniverse.removeGameEntity(entity);
		this.drawables.remove(entity);
		this.entitys.remove(entity);
		if (drawable instanceof Overlappable)
			this.data.getOverlapProcessor().removeOverlappable(
					(Overlappable) drawable);
		deathPlay(entity);
	}
}
