package gameEngine;
public class Vector2
{
    private float x;
    private float y;
    public static final Vector2 UP = new Vector2(0, -1);
    public static final Vector2 DOWN = new Vector2(0, 1);
    public static final Vector2 LEFT = new Vector2(-1, 0);
    public static final Vector2 RIGHT = new Vector2(1, 0);
    
    Vector2(float xPos, float yPos){
        x = xPos;
        y = yPos;
    }
    
    public float getX() {
    	return x;
    }
    
    public float getY() {
    	return y;
    }
    
    public Vector2 addVector(Vector2 num){
        x += num.x;
        y += num.y;
        return this;
    }
    public Vector2 add(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }
    public Vector2 add(float num){
        x += num;
        y += num;
        return this;
    }
    public Vector2 multiply(float x, float y){
        this.x *= x;
        this.y *= y;
        return this;
    }
    public Vector2 multiply(float num){
        x *= num;
        y *= num;
        return this;
    }
    public Vector2 divide(float x, float y){
        this.x /= x;
        this.y /= y;
        return this;
    }
    public Vector2 divide(float num){
        x /= num;
        y /= num;
        return this;
    }
    
    public String toString(){
        return new String(Float.toString(x) + " " + Float.toString(y));
    }
}
