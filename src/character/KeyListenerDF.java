package character;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerDF implements KeyListener {

	Character character;

	public KeyListenerDF(Character character) {
		this.character = character;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		Point p = this.character.getPosition();
		this.character.setSpeedVector( new (int) (p.getX() + 1), p.y);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}