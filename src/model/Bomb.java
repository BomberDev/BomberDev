package models;

import gameframework.motion.blocking.MoveBlocker;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Timer;

import drawable.BombDrawable;

public class Bomb implements BomberEntity, MoveBlocker {

	private final Character owner;
	private final int power;
	private Point position;
	private Timer timer;
	private BombDrawable drawable;

	public Bomb(Character owner, Point position) {
		this.owner = owner;
		this.power = owner.getFirePower();
		this.position = position;
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

}
