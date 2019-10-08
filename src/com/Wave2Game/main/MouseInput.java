package com.Wave2Game.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	
	public void mousePressed(MouseEvent e){
		 int mx = e.getX();
		 int my = e.getY();
		 			// Menu Screen
		 if(Game.gameState == Game.STATE.Menu){
			 if(mouseOver(mx, my, (int)Game.menu.contRect.getX(), (int)Game.menu.contRect.getY(), (int)Game.menu.contRect.getWidth(), (int)Game.menu.contRect.getHeight())){
					if(Game.menu.contBtnActive)
							Game.gameState = Game.STATE.Game;
			 }
			 else
			 if (mouseOver(mx, my, (int)Game.menu.newRect.getX(), (int)Game.menu.newRect.getY(), (int)Game.menu.newRect.getWidth(), (int)Game.menu.newRect.getHeight())){
				 Game.gameState = Game.STATE.NewGame;
			 }
			 else
				 if (mouseOver(mx, my, (int)Game.menu.helpRect.getX(), (int)Game.menu.helpRect.getY(), (int)Game.menu.helpRect.getWidth(), (int)Game.menu.helpRect.getHeight())){
					Game.gameState = Game.STATE.Help;
			 }
			 else if(mouseOver(mx, my, (int)Game.menu.quitRect.getX(), (int)Game.menu.quitRect.getY(), (int)Game.menu.quitRect.getWidth(), (int)Game.menu.quitRect.getHeight())){System.exit(1);
			 }			 
		 }
		 			// Help Screen
		 else if(Game.gameState == Game.STATE.Help){
				if (mouseOver(mx, my, (int) Game.help.backRect.getX(), (int) Game.help.backRect.getY(), (int) Game.help.backRect.getWidth(), (int) Game.help.backRect.getHeight())){
					Game.gameState = Game.STATE.Menu;
					}			
			}
		 			// End Screen
		 else if(Game.gameState == Game.STATE.End){
			 if(mouseOver(mx, my, (int)Game.end.againRect.getX(), (int)Game.end.againRect.getY(), (int)Game.end.againRect.getWidth(), (int)Game.end.againRect.getHeight())){
				 Game.gameState = Game.STATE.NewGame;
			 }
			 else if(mouseOver(mx, my, (int)Game.end.quitRect.getX(), (int)Game.end.quitRect.getY(), (int)Game.end.quitRect.getWidth(), (int)Game.end.quitRect.getHeight())){
				 System.exit(1);
			 }			 
		 }	

	} // end Mouse pressed
	
	

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		return (mx >= x && mx <= x + width && my >= y && my <= y + height);
	}

}
