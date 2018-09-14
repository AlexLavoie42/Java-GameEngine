package testGame;
import gameEngine.GameObject;
import gameEngine.Scenes;

public class StartingScene extends Scenes
{
    public void StartScene(){
        Player player = new Player();
        player.InitGameObject(250, 250, 5, 5, "Player.png", 1, 'P');
        
        GameObject test = new GameObject();
        test.InitGameObject(5, 5, 1, 1, "Player.png", 2, 'T');
        test.tag = "test";
    }
}
