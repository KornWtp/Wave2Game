package com.Wave2Game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class EndScreen {
	public boolean againBtnActive = false;
	public boolean quitBtnActive = false;
	public Rectangle againRect = new Rectangle(210, 250, 200, 64);
	public Rectangle quitRect = new Rectangle(210, 350, 200, 64);
	private Point overPos = new Point(190, 70);
	private Point yourScorePos = new Point(220, 140);
	private Point scorePos = new Point(360, 143);
	private Point highScorePos = new Point(220, 180);
	private Point highScoreValuePos = new Point(360, 183);
	private Point againPos = new Point(240, 293);
	private Point quitPos = new Point(275, 393);
	private String highScoreString = "HighScore:";
	private String gameOverString = "Game Over";
	private String yourScoreString = "Your Score is:";
	private String playAgainString = "Play Again";
	private String quitString = "Quit";
	private int highScoreValue = 0;

	public void tick() {

	}

	public void render(Graphics g) {
		Font fnt = new Font("arial", Font.PLAIN, 50);
		Font fnt2 = new Font("arial", Font.PLAIN, 30);
		Font fnt3 = new Font("arial", Font.PLAIN, 18);
		g.setFont(fnt);
		g.setColor(Color.blue);
		g.drawString(gameOverString, (int) overPos.getX(), (int) overPos.getY());

		g.setFont(fnt3);
		g.drawString(yourScoreString, (int) yourScorePos.getX(), (int) yourScorePos.getY());
		g.setFont(fnt2);
		g.drawString("" + Game.hud.getScore(), (int) scorePos.getX(), (int) scorePos.getY());

		g.setFont(fnt3);
		g.drawString(highScoreString, (int) highScorePos.getX(), (int) highScorePos.getY());
		g.setFont(fnt2);
		g.drawString("" + highScoreValue, (int) highScoreValuePos.getX(), (int) highScoreValuePos.getY());

		g.setColor(Color.black);
		if (againBtnActive) {
			g.fillRect((int) againRect.getX(), (int) againRect.getY(), (int) againRect.getWidth(), (int) againRect.getHeight());
			g.setColor(Color.white);
		}
		g.drawString(playAgainString, (int) againPos.getX(), (int) againPos.getY());
		g.drawRect((int) againRect.getX(), (int) againRect.getY(), (int) againRect.getWidth(), (int) againRect.getHeight());

		g.setColor(Color.black);
		if (quitBtnActive) {
			g.fillRect((int) quitRect.getX(), (int) quitRect.getY(), (int) quitRect.getWidth(), (int) quitRect.getHeight());
			g.setColor(Color.white);
		}
		g.drawString(quitString, (int) quitPos.getX(), (int) quitPos.getY());
		g.drawRect((int) quitRect.getX(), (int) quitRect.getY(), (int) quitRect.getWidth(), (int) quitRect.getHeight());
	}

	public void setHighScore(int highScoreValue){
		this.highScoreValue = highScoreValue;
	}
	public void setHighScoreString(String highScoreString){
		this.highScoreString = highScoreString;
	}
}
