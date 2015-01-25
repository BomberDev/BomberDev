package main;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.game.GameLevel;
import gameframework.gui.GameStatusBarElement;
import gameframework.gui.GameWindow;
import levels.GameLevel1;
import other.PlayerKeyboard;
import player.Player;
import update.Config;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// INITIALIZATION

		GameConfiguration config = new Config(15, 19, 40, 5);
		GameData gameData = new GameData(config);
		ObservableValue<Integer> score = gameData.getScore();
		ObservableValue<Integer> life = gameData.getLife();
		GameCanvas canvas = gameData.getCanvas();


		// PLAYER

		PlayerKeyboard strategyKeyboard = new PlayerKeyboard();
		canvas.addKeyListener(strategyKeyboard);
		Player player = null;
		try{
		player = new Player(gameData, strategyKeyboard);
		player.initDrawable("/Characters/bomberman.png", gameData, 8);
		}catch(IllegalArgumentException e){
			System.out.println("Error:"+e.getLocalizedMessage()+"\n at Main.java an image can't be found");
			System.exit(0);
		}
		strategyKeyboard.setEntity(player);
		
		//add level should after create player
		GameLevel level = new GameLevel1(gameData, player);
		gameData.addLevel(level);
		
		
		//Init gui
		Game game = new GameDefaultImpl(gameData);
		GameWindow gameWindow = new GameWindow("BomberDev", canvas, config,new GameStatusBarElement<Integer>("score",score),new GameStatusBarElement<Integer>("life",life));
		gameWindow.createGUI();
		game.start();
		level.run();

	}
}