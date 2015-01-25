package src.bomberdev;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class LevelsObserver implements Observer {

	protected LevelFinder finder;
	protected Window window;
	protected String name;
	protected File[] oldLevels = new File[0];
	protected File[] newPlugins;

	public LevelsObserver(Window window, LevelFinder finder) {
		this.window = window;
		finder.addObserver(this);
		this.finder = finder;
	}

	@Override
	public void update(Observable observable, Object obj) {
		newPlugins = finder.levelFile();

		removeAllItems();

		addItemsToJMenus(newPlugins);

		oldLevels = newPlugins;

	}

	protected void addItemsToJMenus(File[] filesArray) {

		final String[] plugins = levels(filesArray);

		for (int i = 0; i < plugins.length; i++) {
			addItem(window.getFrame().getMenuBar().getMenu(1), plugins[i]);
		}
	}

	protected String[] levels(File[] filesArray) {

		String[] levels = new String[filesArray.length];

		for (int i = 0; i < filesArray.length; i++) {
			levels[i] = filesArray[i].getName();
		}
		return levels;

	}

	protected void addItem(Menu menu, final String name) {
		int endIndex = name.indexOf(".txt");
		MenuItem item = new MenuItem(name.substring(0, endIndex));

		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}

		});

		menu.add(item);
	}

	protected void removeAllItems() {
		for (int i = 0; i < 2; i++) {
			Menu menu = window.getFrame().getMenuBar().getMenu(1);

			menu.removeAll();
		}
	}
}