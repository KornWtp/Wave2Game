package com.Wave2Game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject{
	Random rand = new Random();
	int n = rand.nextInt(10);
	int m = rand.nextInt(10);
	public BasicEnemy(int x, int y, Handler myHandler) {
		super(x, y, ID.BasicEnemy, myHandler);
		velX = n;
		velY = m;
		width = 16;
		height = 16;
	}

	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT-height) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-width) velX *= -1;
		Game.gameHandler.addObject(new Trail(x, y, Color.red, width, height, 1.0f, 0.02f, Game.gameHandler));

	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x,y,width,height);
	}
}
