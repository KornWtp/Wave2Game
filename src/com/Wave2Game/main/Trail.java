package com.Wave2Game.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float transparency;
	private Color color;
	private int width, height;
	private float transparencyDecrease;

	
	public Trail(int x, int y, Color color, int width, int height, float transparency, float transparencyDecrease, Handler myHandler) {
		super(x, y, ID.Trail, myHandler);
		this.color = color;
		this.width = width;
		this.height = height;
		this.transparency = transparency;
		this.transparencyDecrease = transparencyDecrease;
	}

	public void tick() {
		if(transparency > transparencyDecrease){
			transparency -= transparencyDecrease;
		}else myHandler.removeObject(this);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(transparency));
		g.setColor(color);
		g.fillRect(x,y,width,height);
		g2d.setComposite(makeTransparent(1));
		}

	private AlphaComposite makeTransparent(float transparency){
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, transparency);
	}
	
	public Rectangle getBounds() {
		return null;
	}

}
