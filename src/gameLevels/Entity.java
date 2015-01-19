package gameLevels;


import java.awt.Graphics;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameEntity;

public class Entity extends DrawableImage implements GameEntity,Drawable {

	public Entity(String filename, GameCanvas canvas) {
		super(filename, canvas);
	}
	@Override
	public void draw(Graphics graphics) {
		canvas.drawImage(graphics, image, 50, 50);
	}
}
