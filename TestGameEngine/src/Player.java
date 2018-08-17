public class Player extends GameObject
{
    public float speed = 10;
    boolean canUp = true;
    boolean canDown = true;
    boolean canRight = true;
    boolean canLeft = true;
    public void Update(){
        if(GameController.getInput(Input.W) && canUp) movePos(0, -2);
        if(GameController.getInput(Input.A) && canLeft) movePos(-2, 0);
        if(GameController.getInput(Input.S) && canDown) movePos(0, 2);
        if(GameController.getInput(Input.D) && canRight) movePos(2, 0);
        canLeft = true;
        canRight = true;
        canDown = true;
        canUp = true;
    }
    
    public void onCollision(CollisionInfo collision){
        if(collision.right){
            canLeft = false;
        }
        if(collision.left){ 
            canRight = false;
        }
        if(collision.up){
            canDown = false;
        }
        if(collision.down){
            canUp = false;
        }
    }
    
    public void Start(){
        tag = "Player";
    }
}
