package src.bomberdev;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Observable;

import javax.swing.Timer;

public class LevelFinder extends Observable implements ActionListener {

	// ATTRIBUTES

	protected File directory = null;
	protected final Timer timer = new Timer(1000, this);
	protected File[] knownFile = null;

	// CONSTRUCTOR

	public LevelFinder(File dir) {
		directory = dir;
	}

	// METHODS

	/** Starts the timer. */
	public void start() {
		timer.start();
	}

	/** Stops the timer. */
	public void stop() {
		timer.stop();
	}

	/** The plugin finder saves the files from the directory */
	public void setKnownFile() {
		int directorySize = levelFile().length;
		File[] directoryFiles = levelFile();
		File[] files = new File[directorySize];
		for (int i = 0; i < directorySize; i++) {
			files[i] = directoryFiles[i];
		}

		knownFile = files;
	}

	public File[] levelFile() {
		return directory.listFiles(new LevelFilter());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!Arrays.equals(levelFile(), knownFile)) {
			setChanged();
			notifyObservers(directory);
			clearChanged();
			setKnownFile();
		}
	}

}
