package entityConsole.models;

import java.awt.Point;
import java.awt.Rectangle;

import other.Methods;
import player.Player;

import entityConsole.Console;
import entityConsole.drawable.ItemDrawable;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

public class LevelClearance implements BomberEntity, Movable {

	protected GameData data;
	protected Point position;
	protected Console<LevelClearance, ItemDrawable> console;
	private ItemDrawable drawable;
	public LevelClearance(Point position, GameData data,
			Console<LevelClearance, ItemDrawable> console) {
		this.position = position;
		this.data = data;
		this.console = console;
	}

	public void createDrawable(String filename, int maxSpriteNumber) {
		this.createDrawable(filename, data.getCanvas(), data.getConfiguration()
				.getSpriteSize(), maxSpriteNumber);
	}

	public void createDrawable(String filename, GameCanvas canvas,
			int renderingSize, int maxSpriteNumber) {
		this.drawable = new ItemDrawable(filename, canvas, renderingSize,
				maxSpriteNumber, this);
	}

	public ItemDrawable getDrawable() {
		return this.drawable;
	}

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
		BomberCharacter character = Methods.getPlayerFramArea(data,
				Methods.PTC(data, this.position.x),
				Methods.PTC(data, this.position.y));
		if (character != null&&(character instanceof Player)) {
			this.data.getEndOfGame().setValue(true);
			this.console.deleteEntity(this);
		}
	}

	@Override
	public void onTakingDamage() {
	}

}
