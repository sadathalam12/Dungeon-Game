/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author mdala
 */
import java.util.Random;
public class VampirePiece {
    private int x; 
    private int y; 
    private char vampire; 
    
    public VampirePiece(int gameBoardLength, int gameBoardHeight){
        this.x = new Random().nextInt(gameBoardLength);
        this.y = new Random().nextInt(gameBoardHeight); 
        this.vampire = 'v';
    }
    
    public int getX(){
        return x; 
    }
    
    public int getY(){
        return y; 
    }
    
    public void setX(int x){
        this.x = x; 
    }
    
    public void setY(int y){
        this.y = y; 
    }
    
    public String toString(){
        return "v " + x + " " + y; 
    }
    
    public char getVampire(){
        return vampire; 
    }
}


