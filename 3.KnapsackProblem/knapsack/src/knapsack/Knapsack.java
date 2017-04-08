/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author Cosmin
 */
public class Knapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book b1 = new Book("Dragon Rising",2,5);
        Book b2 = new Book("A blade in the dark",3,5);
        Weapon w1 = new Weapon("Sword",5,10);
        Weapon w2 = new Weapon("Axe",6,20);
        Food f1 = new Food("milk",7,10);
        Food f2 = new Food("meat", 3,5);
        
        Rucsac rucsac = new Rucsac(10);
        Item[] availableItems = {b1, b2, w1, w2};
      //  Algorithm random = new RandomAlgorithm(rucsac,availableItems);
       // random.solve();
       // Algorithm greedy = new GreedyAlgorithm(rucsac,availableItems);
       // greedy.solve(); 
         Algorithm dynamic = new DynamicAlgorithm(rucsac,availableItems);
        dynamic.solve();
               
        
    }
    
}
