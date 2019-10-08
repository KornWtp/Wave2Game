package com.Wave2Game.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

	private Random r = new Random();
	private Color color;
	
	public MenuParticle(int x, int y, Handler myHandler) {
		super(x, y, ID.MenuParticle, myHandler);
		velX = r.nextInt(8)-4;
		velY = r.nextInt(8)-4;
		width = 16;
		height = 16;
		if(velX < 0) velX-=2;
		if(velX >= 0) velX+=3;	
		if(velY < 0) velY-=2;
		if(velY >= 0) velY+=3;
		
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT-height) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH-width) velX *= -1;
		Game.menuHandler.addObject(new Trail(x, y, color, width, height, 0.5f, 0.02f, Game.menuHandler));

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		g.setColor(color);		
		g.fillRect(x,y,width,height);
	}

}
