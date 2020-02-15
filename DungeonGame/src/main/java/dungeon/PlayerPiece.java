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
public class PlayerPiece {
    private int x; 
    private int y; 
    private char player; 
    public PlayerPiece(){
        this.x = 0; 
        this.y = 0; 
        this.player = '@'; 
    }

    
    public int getX() {
        return x; 
    }

    
    public int getY() {
       return y; 
    }
    
    public void setX(int x){
        this.x = x; 
    }
    
    public void setY(int y){
        this.y = y; 
    }
    
    public String toString(){
        return "@ " + x + " " + y;  
    }
    
    public char getPlayer(){
        return player; 
    }
    
}

