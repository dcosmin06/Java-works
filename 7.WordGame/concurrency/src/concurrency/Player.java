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
public class Player implements Runnable {
    private final String name;
    private Game game;
    
    public Player(String name){
        this.name = name;
    }
    
    public void setGame(Game game){
        this.game = game;
    }
    
    private boolean createSubmitWord() throws InterruptedException{
        List<Character> extracted = game.getBag().extractLetters(1);
        if(extracted.isEmpty()) {
            return false;
        }
        
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < 10; i++){
            word.append(extracted.get(0));
        }
        
        game.getBoard().addWord(this.name, word.toString());
        Thread.sleep(300);
        return true;
    }
    
    @Override
    public void run(){
        int rounds = 0;
        boolean value;
        while(rounds < 8){
            try {
                value = createSubmitWord();
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
            rounds++;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("Player ").append(this.name);
        temp.append("is in the game.");
        return temp.toString();
    }
    
}
