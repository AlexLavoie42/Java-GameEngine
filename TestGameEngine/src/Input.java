import java.awt.event.*;
public class Input implements KeyListener, MouseListener, MouseMotionListener
{
    boolean isKeyBeingPressed = false;
    KeyEvent keyBeingPressed;
    MouseEvent mouse;
    
    public static final int Q = KeyEvent.VK_Q;
    public static final int W = KeyEvent.VK_W;
    public static final int E = KeyEvent.VK_E;
    public static final int R = KeyEvent.VK_R;
    public static final int T = KeyEvent.VK_T;
    public static final int Y = KeyEvent.VK_Y;
    public static final int U = KeyEvent.VK_U;
    public static final int I = KeyEvent.VK_I;
    public static final int O = KeyEvent.VK_O;
    public static final int P = KeyEvent.VK_P;
    public static final int A = KeyEvent.VK_A;
    public static final int S = KeyEvent.VK_S;
    public static final int D = KeyEvent.VK_D;
    public static final int F = KeyEvent.VK_F;
    public static final int G = KeyEvent.VK_G;
    public static final int H = KeyEvent.VK_H;
    public static final int J = KeyEvent.VK_J;
    public static final int K = KeyEvent.VK_K;
    public static final int L = KeyEvent.VK_L;
    public static final int Z = KeyEvent.VK_Z;
    public static final int X = KeyEvent.VK_X;
    public static final int C = KeyEvent.VK_C;
    public static final int V = KeyEvent.VK_V;
    public static final int B = KeyEvent.VK_B;
    public static final int N = KeyEvent.VK_N;
    public static final int M = KeyEvent.VK_M;
    
    public void keyReleased(KeyEvent e){
        isKeyBeingPressed = false;
    }
    public void keyPressed(KeyEvent e){
        isKeyBeingPressed = true;
        keyBeingPressed = e;
    }
    public void keyTyped(KeyEvent e){
        
    }
    public void mouseClicked(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseMoved(MouseEvent e){
        mouse = e;
    }
    public void mouseDragged(MouseEvent e){
        
    }
}

