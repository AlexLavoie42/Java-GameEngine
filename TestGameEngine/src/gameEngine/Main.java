package gameEngine;
import testGame.StartingScene;

/*******************************
 * 
 * Created by Alex Lavoie in
 * Programming class cause I was
 * Years ahead and bored.
 * 
 * 
 * Long TODO list if you want to work
 * on this again:
 * 
 * 	Fix Collision boxes
 * 
 * 	Change the way objects are drawn on
 * 	screen so rotation is easier
 * 
 * 	Do all the small class TODOS
 * 
 * 	Create a level saving and 
 * 	creating system through text files
 */



public class Main
{
    public static void main(String[] args){
        GameController.startEngine(new StartingScene(), 1000, 1000);
    }
}