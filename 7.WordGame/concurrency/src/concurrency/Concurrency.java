/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

/**
 *
 * @author Cosmin
 */
public class Concurrency {

   
    public static void main(String[] args) {
        Bag firstBag = new Bag();
        Board firstBoard = new Board();
        Game game = new Game();
        game.setBag(firstBag);
        game.setBoard(firstBoard);
        game.addPlayer(new Player("Cosmin"));
        game.addPlayer(new Player("Alex"));
        game.addPlayer(new Player("Bobby"));
        game.start();
        
    }
    
}
