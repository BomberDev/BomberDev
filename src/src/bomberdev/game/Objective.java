package src.bomberdev.game;

import gameframework.drawing.Drawable;
import gameframework.game.GameLevel;
import gameframework.motion.Movable;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Objective implements Drawable {

	protected BomberLevel level;

	public Objective(BomberLevel level) {
		this.level = level;
	}

	public boolean isDone() {
		return nbOfSurvivors() <= 1;
	}

	public int nbOfSurvivors() {
		int nbOfSurvivors = 0;
		for (int i = 0; i < ; i++) {
			if (players[i].getHealth() > 0)
				nbOfSurvivors++;
		}
		return nbOfSurvivors;
	}

	@Override
	public void draw(Graphics g) {
		if (isDone()) {
			g.setColor(Color.white);
			g.drawString("Game Over.", 100, 100);
		}

	}
}
