package com.Wave2Game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Player extends GameObject{
	private int hurtCounter = 0;
	private int healCounter = 0;
	public Player(int x, int y, Handler myHandler) {
		super(x, y, ID.Player, myHandler);
		height = 32;
		width = 32;
	}

	public void tick(){
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH-width);
		y = Game.clamp(y, 0, Game.HEIGHT-2*height);
		collision();
		if(hurtCounter > 0)
			hurtCounter--;
		if(healCounter > 0)
			healCounter--;
	}

	private void collision() {
		for (int i = 0; i < Game.gameHandler.objectList.size(); i++) {
			GameObject tempObject = Game.gameHandler.objectList.get(i);
			if (tempObject.id == ID.BasicEnemy || tempObject.id == ID.FastEnemy || tempObject.id == ID.SmartEnemy || tempObject.id == ID.BossEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					Game.hud.HEALTH -= 2;
					
					hurtCounter = 30;
					
				}
			}
		}
	}





	public void render(Graphics g){
		if(hurtCounter > 0)
			blinkRed(g, hurtCounter);
		else if(healCounter > 0)
			blinkGreen(g, healCounter);
		else
		{
			g.setColor(Color.white);
			g.fillRect(x, y, width, height);
		}
	}

	private void blinkRed(Graphics g, int hurtCounter){
		if(hurtCounter/5 == 5 || hurtCounter/5 == 3 || hurtCounter/5 == 1){
			g.setColor(Color.red);
			g.fillRect(x, y, width, height);
		}
	}
	private void blinkGreen(Graphics g, int healCounter){
		if(healCounter/5 == 5 || healCounter/5 == 3 || healCounter/5 == 1){
			g.setColor(Color.green);
			g.fillRect(x, y, width, height);
		}
	}
}
