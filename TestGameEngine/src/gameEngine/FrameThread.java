package gameEngine;

public class FrameThread extends Thread
{
    private boolean active = true;
    private int frameRateLock = 300;
    public void run(){
        while(active){
            GameController.updateGameObjectsOnFrame();
            GameController.updateFrame();
            if(frameRateLock != 0){
                try{
                    Thread.sleep(1000/frameRateLock);
                }
                catch(InterruptedException ex){
                    GameController.printError("Frame thread Interupted");
                }
            }
        }
    }
    
    public void setActive(boolean a){
        active = a;
    }
    
    public void setFrameLock(int f){
        frameRateLock = f;
    }
}
