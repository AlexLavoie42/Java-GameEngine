import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class Sprite
{
    private String spriteFile;
    private BufferedImage image;
    
    Sprite(String file){
        spriteFile = file;
        try{
            image = ImageIO.read(new File(file));
        }catch(IOException ex){
            GameController.printError(file + " not found");
        }
    }
    
    public String getFile(){
        return spriteFile;
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
    public Vector2 getSize(){
        return new Vector2(image.getWidth(), image.getHeight());
    }
}
