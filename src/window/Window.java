package window;

import gameLevels.GameLevel1;
import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

import java.net.MalformedURLException;

public class Window {
	public static void main(String[] argv) throws MalformedURLException,
			InterruptedException {

		int nbRows = 30;
		int nbColumns = 40;
		int spriteSize = 16;
		int nbLives = 3;

		GameConfiguration config = new GameConfiguration(nbRows, nbColumns,
				spriteSize, nbLives);
		GameData gameData = new GameData(config);
		gameData.addLevel(new GameLevel1(gameData));
		GameCanvas canvas = gameData.getCanvas();

		Game game = new GameDefaultImpl(gameData);
		/*
		 * GameUniverseViewPort universeViewPort = new
		 * GameUniverseViewPortDefaultImpl();
		 * universeViewPort.setGameData(gameData); universeViewPort.paint();
		 */
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();
		GameWindow window = new GameWindow(canvas, config, score, life,
				gameData, game);

		score.setValue(600);

		window.createGUI();

		game.start();

	}
}
