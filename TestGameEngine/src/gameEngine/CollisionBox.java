package gameEngine;

import java.awt.Rectangle;

public class CollisionBox
{
    private Vector2 pos;
    private Vector2 size;
    private GameObject gameObject;
    private boolean isSolid;
    private Rectangle rect;
    
    CollisionBox(boolean solid, GameObject object){
        isSolid = solid;
    }
    
    CollisionBox(Vector2 pos, Vector2 size, boolean solid, GameObject object){
        isSolid = solid;
        this.pos = pos;
        this.size = size;
        calcQuad();
    }
    
    public CollisionInfo testCollision(CollisionBox collider){
		return null;
    }
    
    
    
    public void setSize(Vector2 size) {
    	this.size = size;
    	calcQuad();
    }
    
    public void setPos(Vector2 pos) {
    	this.pos = pos;
    	calcQuad();
    }
    
    public void setBox(Vector2 pos, Vector2 size) {
    	this.pos = pos;
    	this.size = size;
    	calcQuad();
    }
    
    public Vector2 getSize() {
    	return size;
    }
    
    public Vector2 getPos() {
    	return pos;
    }
    
    private void calcQuad() {
    	rect = new Rectangle();
    	
    }
}
