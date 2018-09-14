package gameEngine;
public class CollisionBox
{
    private Vector2 pos;
    private Vector2 size;
    private GameObject gameObject;
    private boolean isSolid;
    private Vector2[] quad;
    
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
    	quad = new Vector2[4];
    	quad[0] = pos;
    	quad[1] = new Vector2(pos.getX() + size.getX(), pos.getY());
    	quad[2] = new Vector2(pos.getX(), pos.getY() + size.getY());
    	quad[3] = new Vector2(pos.getX() + size.getX(), pos.getY() + size.getY());
    }
}
