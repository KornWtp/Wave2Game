package com.Wave2Game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y, height, width;
	protected ID id;
	protected double velX, velY;
	protected Handler myHandler;

	public GameObject(int x, int y, ID id, Handler myHandler) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.myHandler = myHandler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ID getId() {
		return id;
	}

	public double getVelX() {
		return velX;
	}

	public double getVelY() {
		return velY;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

}
