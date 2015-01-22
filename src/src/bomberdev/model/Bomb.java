package src.bomberdev.model;

import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import src.bomberdev.drawable.BombDrawable;

public class Bomb implements BomberEntity, MoveBlocker{

	private final BomberUniverse univ;
	private final Character owner;
	private final int power;
	private final int area;
	private Point position;
	private Timer timer;
	private BombDrawable drawable;
	private static final int DELAY;
	
	static {
		DELAY = 3;
	}
	
	public Bomb(BomberUniverse univ, Character owner, Point position) {
		this.univ = univ;
		this.owner = owner;
		this.power = owner.getFirePower();
		this.area = owner.getFireArea();
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
		this.drawable.animExplode();
		this.owner.incrementBombStock();
		this.univ.explosionOccuring(this);
		this.univ.removeGameEntity(this);
	}
	
	@Override
	public void onTakingDamage(int damage) {
		explode();
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(100, 100);
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

	public int getFirePower() {
		return this.power;
	}

	public int getAreaPower() {
		return this.area;
	}
	
}
