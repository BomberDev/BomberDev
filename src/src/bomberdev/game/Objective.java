package src.bomberdev.game;

import gameframework.drawing.Drawable;
import gameframework.game.GameLevel;

import java.awt.Color;
import java.awt.Graphics;

import src.bomberdev.model.Character;

public class Objective implements Drawable {

	protected Character[] players;
	protected GameLevel level;

	public Objective(Character[] players) {
		this.players = players;
	}

	public boolean isDone() {
		return nbOfSurvivors() <= 1;
	}

	public int nbOfSurvivors() {
		int nbOfSurvivors = 0;
		for (int i = 0; i < players.length; i++) {
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
