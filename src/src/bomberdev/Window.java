package src.bomberdev;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameConfiguration;
import gameframework.gui.GameWindow;

import java.awt.Frame;
import java.awt.Menu;
import java.io.File;

public class Window extends GameWindow {

	protected LevelFinder finder = new LevelFinder(new File(
			"target/classes/Resources/Maps"));
	protected LevelsObserver levelsObserver = new LevelsObserver(this, finder);

	public Window(String name, GameCanvas gameCanvas,
			GameConfiguration configuration, ObservableValue<Integer> score,
			ObservableValue<Integer> life) {
		super(name, gameCanvas, configuration, score, life);
	}

	public Frame getFrame() {
		return frame;
	}

	@Override
	public void createGUI() {
		super.createGUI();
		frame.getMenuBar().add(new Menu("Levels"));
		finder.start();
	}
}
