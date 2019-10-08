package com.Wave2Game.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	// สร้าง 
	LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < objectList.size(); i++){
			GameObject tempObject = objectList.get(i);
			tempObject.tick();
		}
	}
	public void render(Graphics g){
		for(GameObject tempObject : objectList)
				tempObject.render(g);
	}
	
	public void addObject(GameObject object){
		objectList.add(object);
	}
	public void removeObject(GameObject object){
		objectList.remove(object);
	}
	public void clearEnemies(){
		for(GameObject tempObject : objectList){
			if(tempObject.getId() == ID.Player){
			objectList.clear();
			addObject(Game.player);
			}
		}
	}
}
