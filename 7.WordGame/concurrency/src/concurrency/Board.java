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
public class Board {
    private final List<String> words = new ArrayList<>();
    public Board(){
    }
    
    public synchronized void addWord(String playerName, String word){
       
        words.add(word);
        System.out.println("Player "+playerName+" submitted the word "+word); 
    }
}
