
public class UpdateThread extends Thread
{
    private boolean active = true;
    public void run(){
        while(active){
            GameController.updateGameObjects();
            //GameController.checkCollisions();
            try{
                Thread.sleep(31);
            }
            catch(InterruptedException ex){
                GameController.printError("Update thread Interupted");
            }
        }
    }
    
    public void setActive(boolean a){
        active = a;
    }
}
