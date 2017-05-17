/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.*;

/**
 *
 * @author Cosmin
 */
public class Game {
    private Bag bag;
    private Board board;
    private final List<Player> players = new ArrayList<>();
    
    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }
    
    public void setBag(Bag bag){
        this.bag = bag;
    }
    
    public void setBoard(Board board){
        this.board = board;
    }
    
    public Bag getBag(){
        return bag;
    }
    
    public Board getBoard(){
        return board;
    }
    
    public void start(){
        for(int i = 0; i < players.size(); i++){
            new Thread(players.get(i)).start();
        }
    }
}
