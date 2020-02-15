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
import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 

public class Dungeon {
    
    private List<VampirePiece> vampires; 
    private GameBoard gameBoard; 
    private PlayerPiece player;
    boolean vampiresMove; 
    private int moves; 
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.gameBoard = new GameBoard(length, height); 
        this.vampires = new ArrayList<VampirePiece>(); 
        this.player = new PlayerPiece(); 
        for(int i = 0; i<vampires; i++){
            this.vampires.add(new VampirePiece(length,height));
        }
         
        this.vampiresMove =vampiresMove; 
        this.moves = moves; 
       
    }
    
    public void run(){
            Scanner s = new Scanner(System.in);
            System.out.println(moves);
            System.out.println("");
            System.out.println(player);
            for(VampirePiece v: vampires){
                System.out.println(v);
            }
            System.out.println("");
            gameBoard.setPlayer(player);
            for(VampirePiece v: vampires){
            gameBoard.setVampire(v);
            }
            gameBoard.printGameBoard();
            System.out.println("");
            
            while(true){
                if(moves==0 && vampires.size()!= 0){
                    System.out.println("YOU LOSE");
                    break;
                }
                if(vampires.size()== 0){
                    System.out.println("YOU WIN");
                    break;
                }
                List<VampirePiece> deadVamps = new ArrayList<VampirePiece>(); 
               
                String commands = s.nextLine(); 
                String[] b = new String[commands.length()]; 
                for(int i= 0; i<commands.length(); i++){
                    b[i] = commands.substring(i, i+1); 
                }
                
                for(int i=0; i<b.length; i++){
                    if(b[i].equals("w")){
                        gameBoard.movePlayerUp(player);
                        
                    }else if(b[i].equals("s")){
                        gameBoard.movePlayerDown(player);
                      
                    }else if(b[i].equals("a")){
                        gameBoard.movePlayerLeft(player);
                        
                    }else if(b[i].equals("d")){
                        gameBoard.movePlayerRight(player);
                        
                    }
                    deadVamps = this.deadVampires();
                    vampires.removeAll(deadVamps);
                    
                }
                
               if(vampiresMove){ 
               for(VampirePiece v: vampires){
                    for(int i = 0; i<commands.length(); i++){
                        gameBoard.moveVampire(vampiresMove, v);
                       deadVamps= this.deadVampires(); 
                        
                        if(v.getX()==player.getX() && v.getY()==player.getY()){
                            break;
                        }
                    }
                }
               vampires.removeAll(deadVamps); 
               }
                
                
                moves--; 
                System.out.println(moves);
                System.out.println("");
                System.out.println(player);
                for(VampirePiece v: vampires){
                    System.out.println(v);
                }
                System.out.println("");
                gameBoard.printGameBoard();
            }
        
    }
    
    private List<VampirePiece> deadVampires(){
        List<VampirePiece> deadVampires = new ArrayList<VampirePiece>(); 
        for(VampirePiece v: vampires){
            if(v.getX() == player.getX() && v.getY() == player.getY()){
                deadVampires.add(v);
            }
        }
         return deadVampires; 
    }
    
}
    

