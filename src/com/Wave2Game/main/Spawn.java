package com.Wave2Game.main;

import java.util.Random;

public class Spawn {

	private Random r = new Random();
	private int prevLevel = -1;
	GameObject tempCoin = null;

	public void tick(){
		if(Game.hud.getLevel() != prevLevel){ // do only when level changes
			prevLevel = Game.hud.getLevel();
			if(Game.hud.getLevel() == 2)
				Game.gameHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32), Game.gameHandler));
			else if(Game.hud.getLevel() >= 3 && Game.hud.getLevel() <= 5)
				Game.gameHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32), Game.gameHandler));
			else if(Game.hud.getLevel() >= 6  && Game.hud.getLevel() <= 8){
				Game.gameHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32), Game.gameHandler));
				//Game.gameHandler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32), Game.gameHandler));
			}
			else if(Game.hud.getLevel() >= 9){
				Game.gameHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32), Game.gameHandler));
				//Game.gameHandler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32), Game.gameHandler));
				//Game.gameHandler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-32),r.nextInt(Game.HEIGHT-32), Game.gameHandler));
			}
		} // only if level changes

		// throw coin until in is not intersecting other coins or HUD
		
	}
}
