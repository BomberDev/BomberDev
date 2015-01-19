package other;

import gameframework.game.GameEntity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import player.Player;

public class ActionKeyboard implements KeyListener {

	GameEntity entity;

	public ActionKeyboard(GameEntity entity) {
		this.entity = entity;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'x')
			((Player) entity).action(1);
		else if (e.getKeyChar() == 'c')
			((Player) entity).action(2);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根

	}

}
