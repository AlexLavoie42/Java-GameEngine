package gameEngine;
/*
 * Main class that handles everything needed to run the game
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
public class GameController
{
    private static int windowSizeX;
    private static int windowSizeY;
    private static ArrayList<GameObject> currentObjects = new ArrayList<GameObject>();
    private static int nextObjectNum = 0;
    private static JFrame frame = new JFrame();
    private static Scenes currentScene;
    private static Input input = new Input();
    private static int framesPerSec;
    private static long lastFrame;
    private static int FPSlimit = 60;
    private static UpdateThread updateThread = new UpdateThread();
    private static FrameThread frameThread = new FrameThread();
    private static boolean isFullscreen = true;
    
    
    //sets up jframe window
    public static void InitWindow(){
        if(isFullscreen) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowSizeX, windowSizeY);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
        frame.addKeyListener(input);
        frame.addMouseListener(input);
        frame.addMouseMotionListener(input);
        frame.repaint();
    }
    
    
    //allows you to change window size while running
    public static void ChangeWindowSize(int x, int y){
        windowSizeX = x;
        windowSizeY = y;
        InitWindow();
    }
    
    //adds a game object to the array of loaded gameobjects
    public static int InitGameObject(GameObject gameObject, int l){
        if(currentObjects.size() < l){
            currentObjects.add(gameObject);
        }else{
            currentObjects.add(l, gameObject);
        }
        gameObject.Start();
        InitWindow();
        return ++nextObjectNum;
    }
    
    //finds a GameObject from the list of loaded GameObjects and removes it
    public static void RemoveGameObject(int objectNum){
        currentObjects.remove(objectNum);
        currentObjects.trimToSize();
        nextObjectNum--;
    }
    
    //draws loaded game objects on screen
    //TODO: make sure this is actually efficient and there are no memory leaks
    public static void PaintGameObjects(){
        frame.add(new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                for(int i = 0; i < currentObjects.size(); i++){
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.drawImage(currentObjects.get(i).getImage(), currentObjects.get(i).transform, null);
                    
                }
            }
        });
        frame.repaint();
    }
    
    //tests for any key being pressed
    public static boolean getInput(int key){
        if(input.isKeyBeingPressed){
            if(input.keyBeingPressed.getKeyCode() == key) return true;
            else return false;
        }else return false;
    }
    
    //returns x y position of cursor in frame
    public static Vector2 getMousePos(){
        if(input.mouse != null) return new Vector2(input.mouse.getX(), input.mouse.getY());
        else return new Vector2(0, 0);
    }
   
    //prints an error to console
    public static void printError(String error){
        System.out.println("Error: " + error);
    }
    
    //prints info to console
    public static void printInfo(String info){
        System.out.println("Info: " + info);
    }
    
    //prints int to console
    public static void printInfo(int info){
        System.out.println("Info: " + info);
    }
    
    //prints float to console
    public static void printInfo(float info){
        System.out.println("Info: " + info);
    }
    
    //prints warning to console
    public static void printWarning(String warning){
        System.out.println("Warning: " + warning);
    }
    
    //calls update function on all loaded GameObjects 
    public static void updateGameObjects(){
        for(int x = 0; x < currentObjects.size(); x++){
            currentObjects.get(x).Update();
        }
    }
    
    //calls updateOnFrame function for all loaded GameObjects
    public static void updateGameObjectsOnFrame(){
        for(int x = 0; x < currentObjects.size(); x++){
            currentObjects.get(x).UpdateOnFrame();
        }
    }
    
    //stores average frames per second in int
    public static void getFPS(){
        if(System.currentTimeMillis() >= lastFrame + 1000){
            lastFrame = System.currentTimeMillis();
            int fps = framesPerSec;
            framesPerSec = 0;
        }
    }
    
    //checks all loaded GameObjects for collisions
    //TODO Get working again
    public static void checkCollisions(){
        for(int x = 0; x < currentObjects.size(); x++){
            for(int i = 0; i < currentObjects.size(); i++){
                if(x == i) continue;
                CollisionInfo info = currentObjects.get(x).collider.testCollision(currentObjects.get(i).collider);
                if(info != null){
                    currentObjects.get(x).onCollision(info);
                }
            }
        }
    }
    
    //changes current scene
    public static void changeScene(Scenes scene){
        currentScene = scene;
        currentObjects = null;
        currentScene.StartScene();
    }
    
    //starts the engine and threads required to run
    public static void startEngine(Scenes firstScene, int windowX, int windowY){
        currentScene = firstScene;
        windowSizeX = windowX;
        windowSizeY = windowY;
        InitWindow();
        currentScene.StartScene();
        updateThread.start();
        updateThread.setPriority(2);
        frameThread.start();
        frameThread.setPriority(1);
        frameThread.setFrameLock(FPSlimit);
    }
    
    //updates frame
    public static void updateFrame(){
        currentScene.RunScene();
        framesPerSec++;
        getFPS();
    }
}

