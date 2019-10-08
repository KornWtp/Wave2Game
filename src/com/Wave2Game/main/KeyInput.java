package com.Wave2Game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

//import Game.STATE;

public class KeyInput extends KeyAdapter{

	private boolean[] keyDown = new boolean[4];

	private Random r = new Random();
	
	public KeyInput(){
		keyDown[0] = false; // w
		keyDown[1] = false; // s
		keyDown[2] = false; // d
		keyDown[3] = false; // a
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		//Game Screen
	if(Game.gameState == Game.STATE.Game || Game.gameState == Game.STATE.NewGame || Game.gameState == Game.STATE.Boss){
		if(key == KeyEvent.VK_ESCAPE) 
			Game.gameState = Game.STATE.Menu;
	
		for(int i = 0; i < Game.gameHandler.objectList.size(); i++){
		GameObject tempObject = Game.gameHandler.objectList.get(i);
		if(tempObject.getId() == ID.Player){
			if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP){tempObject.setVelY(-5); keyDown[0]=true;}
			if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){tempObject.setVelY(5); keyDown[1]=true;}
			if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){tempObject.setVelX(5); keyDown[2]=true;}
			if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){tempObject.setVelX(-5); keyDown[3]=true;}
			}
		}		
	}
		// Menu Screen
	else if(Game.gameState == Game.STATE.Menu){
	if(key == KeyEvent.VK_ESCAPE) 
		System.exit(1);
	
	if(key == KeyEvent.VK_UP){
		if(Game.menu.newBtnActive){
			if(Game.gameHandler.objectList.size() != 0) { // if Continue button is on the screen
				Game.menu.contBtnActive = true;
				Game.menu.newBtnActive = false;
			}
		}
		else if(Game.menu.helpBtnActive){
				Game.menu.newBtnActive = true;
				Game.menu.helpBtnActive = false;
		}
		else if(Game.menu.quitBtnActive){
			Game.menu.helpBtnActive = true;
			Game.menu.quitBtnActive = false;
		}
		else if(!Game.menu.contBtnActive && !Game.menu.newBtnActive && !Game.menu.helpBtnActive && !Game.menu.quitBtnActive)
			if(Game.gameHandler.objectList.size() != 0) // if Continue button is on the screen
				Game.menu.contBtnActive = true;
			else
				Game.menu.newBtnActive = true;
	}

	else if(key == KeyEvent.VK_DOWN){
		if(Game.menu.helpBtnActive){
			Game.menu.quitBtnActive = true;
			Game.menu.helpBtnActive = false;
		}
		else if(Game.menu.newBtnActive){
				Game.menu.helpBtnActive = true;
				Game.menu.newBtnActive = false;
		}
		else if(Game.menu.contBtnActive){
				Game.menu.newBtnActive = true;
				Game.menu.contBtnActive = false;
		}
		else if(!Game.menu.contBtnActive && !Game.menu.newBtnActive && !Game.menu.helpBtnActive && !Game.menu.quitBtnActive)
				if(Game.gameHandler.objectList.size() != 0) // if Continue button is on the screen
					Game.menu.contBtnActive = true;
				else
					Game.menu.newBtnActive = true;
	}
	else if(key == KeyEvent.VK_ENTER){		
		if(Game.menu.contBtnActive)
			Game.gameState = Game.STATE.Game;
		//else if(Game.menu.newBtnActive) Game.gameState = STATE.NewGame;
		else if(Game.menu.helpBtnActive) Game.gameState = Game.STATE.Help;
		else if(Game.menu.quitBtnActive) System.exit(1);
	}
}
 			// Help Screen
else if(Game.gameState == Game.STATE.Help){
	if(key == KeyEvent.VK_ESCAPE) {
		Game.gameState = Game.STATE.Menu;
		Game.help.backBtnActive = false;		
	}
	else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) 
		Game.help.backBtnActive = true;
	else if(key == KeyEvent.VK_ENTER && Game.help.backBtnActive){
		Game.gameState = Game.STATE.Menu;
		Game.help.backBtnActive = false;	
	}		
}

	// End Screen
else if(Game.gameState == Game.STATE.End){
	if(key == KeyEvent.VK_ESCAPE) 
		Game.gameState = Game.STATE.NewGame;
	else if(key == KeyEvent.VK_UP){
		if(Game.end.quitBtnActive){
			Game.end.againBtnActive = true;
			Game.end.quitBtnActive = false;
		}
		else if(!Game.end.againBtnActive && !Game.end.quitBtnActive)
			Game.end.againBtnActive = true;
	}
	else if(key == KeyEvent.VK_DOWN){
		if(Game.end.againBtnActive){
			Game.end.quitBtnActive = true;
			Game.end.againBtnActive = false;
		}
		else if(!Game.end.againBtnActive && !Game.end.quitBtnActive)
			Game.end.againBtnActive = true;		
	}
	else if(key == KeyEvent.VK_ENTER){		
		if(Game.end.againBtnActive) Game.gameState = Game.STATE.NewGame;
		else if(Game.end.quitBtnActive) System.exit(1);
	}

}	
}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();

		for(int i = 0; i < Game.gameHandler.objectList.size(); i++){
			GameObject tempObject = Game.gameHandler.objectList.get(i);

			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) keyDown[0] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) keyDown[1] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) keyDown[2] = false; //tempObject.setVelX(0);
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) keyDown[3] = false; //tempObject.setVelX(0);

				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);

			}
		}

	}
}
