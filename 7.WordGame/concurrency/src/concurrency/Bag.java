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
public class Bag {
    private final Queue<Character> letters = new LinkedList<>();
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public Bag(){
       for(int i=0; i < 26; i++){
           letters.add(this.alphabet.charAt(i));
       }
    }
    
    
    public synchronized List<Character> extractLetters(int howMany){
        List<Character> extracted = new ArrayList<>();
        for(int i = 0; i < howMany; i++){
            if(letters.isEmpty()) break;
            extracted.add(letters.poll());
        }
        return extracted;
    }
    
}
