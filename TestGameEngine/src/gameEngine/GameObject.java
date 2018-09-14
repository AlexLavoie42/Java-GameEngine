package gameEngine;
import java.awt.image.*;
import java.awt.geom.*;
public class GameObject
{
    private Sprite sprite;
    //The number given to the GameObject upon initialization
    private int objectNum;
    //A Vector2 that hold the size of the image associated with the GameObject
    private Vector2 size;
    //private float rotation;
    //The layer the GameObject is rendered on
    //TODO: fix
    private float rotation;
    protected int layer;
    //public CollisionBox collider;
    //The char variable associated with the GameObject
    //TODO: implement level creator through text file using this system
    protected char levelChar;
    public String tag;
    //The AffineTransform holds all the position scale and rotation data of the object
    public AffineTransform transform;
    public CollisionBox collider;
    
    
    //Initialize all the Gameobjects variable and adds it to the game controller
    public void InitGameObject(float posX, float posY, float scaleX, float scaleY, String file, int layer, char level){
        transform = new AffineTransform();
        transform.translate(posX, posY);
        transform.scale(scaleX, scaleY);
        sprite = new Sprite(file);
        size = sprite.getSize();
        collider = new CollisionBox(new Vector2(posX, posY), size , true, this);
        this.layer = layer;
        levelChar = level;
        objectNum = GameController.InitGameObject(this, layer);
    }
    
    //Returns the size of the GameObject
    public Vector2 getSize(){
        return size;
    }
    
    //Return the position of the GameObject
    public Vector2 getPos(){
        return new Vector2((float)transform.getTranslateX(), (float)transform.getTranslateY());
    }
    
    //Sets the position of the GameObject
    public void setPos(float x, float y){
        AffineTransform tran = new AffineTransform();
        tran.translate(x, y);
        tran.scale(transform.getScaleX(), transform.getScaleY());
        //Add to code when rotation is working
        //trans.rotate(rotation);
        transform.setTransform(tran);
        tran = null;
    }
    
    //Adds the specified amount to the GameObjects position
    public void movePos(float x, float y){
        transform.translate(x, y);
        //updateCollider();
    }
    
    //Adds the specified amount in a Vector2 to the GameObjects position
    public void movePos(Vector2 pos){
        transform.translate(pos.getX(), pos.getY());
        //updateCollider();
    }
    
    //Changes the sprite of the GameObject
    public void changeSprite(String file){
        sprite = new Sprite(file);
    }
    
    //Returns the buffered image in the GameObjects sprite
    public BufferedImage getImage(){
        return sprite.getImage();
    }
    
    //Updates the size and position of the GameObjects collision box to match its own
    public void updateCollider(){
    	Vector2 objectSize = new Vector2(size.getX() * (float)transform.getScaleX(), size.getY() * (float)transform.getScaleY());
    	Vector2 objectPos = new Vector2((float)transform.getTranslateX(), (float)transform.getTranslateY());
        if(objectPos != collider.getPos()) {
        	if(objectSize != collider.getSize()) {
        		collider.setBox(objectPos, objectSize);
        	}else {
        		collider.setPos(objectPos);
        	}
        }else if(objectSize != collider.getSize()) collider.setSize(objectSize);
    }
    
    //Function that is called when the GameObject is initialized
    public void Start(){
        
    }
    
    //Function that is called every tick on the update thread
    public void Update(){
        
    }
    
    //Function that is called every frame update
    public void UpdateOnFrame(){
        
    }
    
    //Function that is called when a collision is detected
    public void onCollision(CollisionInfo info){
        
    }

    
    public void rotate(float deg){
        rotation += deg;
        if(rotation > 360) rotation = 0;
        transform.rotate(Math.toRadians(-deg), size.getX()/2, size.getY()/2);
    }
}
