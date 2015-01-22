package src.bomberdev.model;

import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import src.bomberdev.drawable.BombDrawable;

public class Bomb implements BomberEntity, MoveBlocker{

	private final Character owner;
	private final int power;
	private Point position;
	private Timer timer;
	private BombDrawable drawable;
	private static final int DELAY;
	
	static {
		DELAY = 3;
	}
	
	public Bomb(Character owner, Point position) {
		this.owner = owner;
		this.power = owner.getFirePower();
		this.position = position;
		this.timer = configureTimer();
	}
	
	protected Timer configureTimer() {
		Timer timer = new Timer(DELAY, new BombTimer());
		timer.setRepeats(false);
		timer.start();
		return timer;
	}
	
	public void explode() {
		// TODO: check for all GameEntity caught in the explosion.
		this.drawable.animExplode();
		this.owner.incrementBombStock();
	}
	
	@Override
	public void onTakingDamage(int damage) {
		explode();
	}
	
	@Override
	public Rectangle getBoundingBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}


	private class BombTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			explode();
		}

		
		
	}

	
}
