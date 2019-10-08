package com.Wave2Game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Help {
	public boolean backBtnActive = false;
	public Rectangle backRect = new Rectangle(210, 350, 200, 64);
	private Point helpPos = new Point(250, 70);
	private Point backPos = new Point(275, 393);
	private Point infoPos1 = new Point(100, 150);
	private Point infoPos2 = new Point(100, 200);
	private String helpString = "Help";
	private String backString = "Back";
	private String infoString1 = "Use WSAD or arrows to move and dodge the enemies.";
	private String infoString2 = "Press ESC for Menu.";


	public void tick(){}
	
	public void render(Graphics g){
		Font fnt = new Font("arial", Font.PLAIN, 50);
		Font fnt2 = new Font("arial", Font.PLAIN, 30);
		Font fnt3 = new Font("arial", Font.PLAIN, 18);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString(helpString, (int)helpPos.getX(), (int)helpPos.getY());
		
		g.setFont(fnt3);
		g.drawString(infoString1, (int)infoPos1.getX(), (int)infoPos1.getY());
		g.drawString(infoString2, (int)infoPos2.getX(), (int)infoPos2.getY());

		g.setFont(fnt2);		
			
			g.setColor(Color.black);
			g.fillRect((int)backRect.getX(), (int)backRect.getY(), (int)backRect.getWidth(), (int)backRect.getHeight());
			g.setColor(Color.white);
			g.drawRect((int)backRect.getX(), (int)backRect.getY(), (int)backRect.getWidth(), (int)backRect.getHeight());
			g.drawString(backString, (int)backPos.getX(), (int)backPos.getY());
			if(backBtnActive){
				g.fillRect((int)backRect.getX(), (int)backRect.getY(), (int)backRect.getWidth(), (int)backRect.getHeight());
				g.setColor(Color.black);
				g.drawString(backString, (int)backPos.getX(), (int)backPos.getY());
			}
	}
}
