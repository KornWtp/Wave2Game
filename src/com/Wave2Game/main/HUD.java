package com.Wave2Game.main;

import java.awt.*;

public class HUD {
	
	public int HEALTH = 100;
	private int greenValue = 255;
	private Rectangle hudRect = new Rectangle(15,15,200,32);
	private Point scorePos = new Point(15, 64);
	private Point levelPos = new Point(15, 80);
	private String scoreString = "Score: ";
	private String levelString = "Level: ";
	private int score = 0;
	private int level = 1;
		
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = HEALTH*2;
		greenValue = Game.clamp(greenValue, 0, 255);
		score++;
		if(score % 250 == 249 && Game.gameState != Game.STATE.Boss) // stop counting levels if it is boss
			level++;
		if(HEALTH == 0)
			Game.gameState = Game.STATE.End;
			
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect((int)hudRect.getX(), (int)hudRect.getY(), (int)hudRect.getWidth(), (int)hudRect.getHeight());
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect((int)hudRect.getX(), (int)hudRect.getY(), 2*HEALTH, (int)hudRect.getHeight());
		g.setColor(Color.white);
		g.drawRect((int) hudRect.getX(), (int) hudRect.getY(), (int)hudRect.getWidth(), (int) hudRect.getHeight());

		g.drawString(scoreString + score, (int)scorePos.getX(), (int)scorePos.getY());
		g.drawString(levelString + level, (int)levelPos.getX(), (int)levelPos.getY());
	}
	
	public void setScore(int score){
		this.score = score;
	}
	public int getScore(){
		return score;
	}
	public void setLevel(int level){
		this.level = level;
	}
	public int getLevel() { return level; }
	public Rectangle getBounds(){
		return hudRect;
	}

}
