public class CollisionBox
{
    public Vector2 pos;
    public Vector2 size;
    private boolean isSolid;
    public GameObject gameObject;
    
    CollisionBox(boolean solid, GameObject object){
        isSolid = solid;
    }
    
    CollisionBox(Vector2 pos, Vector2 size, boolean solid, GameObject object){
        isSolid = solid;
        this.pos = pos;
        this.size = size;
    }
    
    public CollisionInfo testCollision(CollisionBox collider){
        if(collider.pos.x + collider.size.x > pos.x && collider.pos.x < pos.x + size.x && collider.pos.y + collider.size.y > pos.y && collider.pos.y < pos.y + size.y){
            CollisionInfo collision = new CollisionInfo();
            if(collider.pos.x + collider.size.x > pos.x && collider.pos.x < pos.x + 5) collision.left = true; ;
            if(collider.pos.x < pos.x + size.x && collider.pos.x + collider.size.x > pos.x + size.x - 5) collision.right = true;
            return collision;
        }
        else{
            return null;
        }
    }
    
    
}
