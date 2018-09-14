package gameEngine;

public class CollisionInfo
{
    GameObject collider;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int collisions;
    
    public boolean getDirection(String dir) {
    	switch(dir) {
    		case "UP" : return up;
    		case "DOWN" : return down;
    		case "LEFT" : return left;
    		case "RIGHT" : return right;
    		default : return false;
    	}
    }
    
    public int getCollisionNum() {
    	return collisions;
    }
    
    public void setCollision(CollisionInfo collision) {
    	up = collision.getDirection("UP");
    	down = collision.getDirection("DOWN");
    	left = collision.getDirection("LEFT");
    	right = collision.getDirection("RIGHT");
    	collisions = collision.getCollisionNum();
    }
}
