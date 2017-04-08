/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cosmin
 */
public class RandomAlgorithm implements Algorithm{
    private Rucsac rucsac;
    private Item[] items = null;
    private int totalValue=0;
    private int totalWeight;
    
    RandomAlgorithm(Rucsac knapsack, Item[] availableItems)
    {
        rucsac = knapsack;
        items = availableItems;
    }
    
    @Override
    public void solve(){
        int[] frequency = new int[items.length];
        int maxWeight = rucsac.getCapacity();
        totalWeight = maxWeight;
        for(int e: frequency)
            e = 0;
        int randomNumber = ThreadLocalRandom.current().nextInt(0,items.length);
        
        while(totalWeight > 0)
        {
            if(totalWeight < items[randomNumber].getWeight())
            {
                System.out.println("Not enough space for "+items[randomNumber].getName());
                break;
            }
            totalWeight-=items[randomNumber].getWeight();
            totalValue+=items[randomNumber].getValue();
            frequency[randomNumber] = 1;
            rucsac.add(items[randomNumber]);
            while(frequency[randomNumber] == 1)
            {
                randomNumber = ThreadLocalRandom.current().nextInt(0,items.length);
            }
        }
        rucsac.orderValue();
        System.out.println(rucsac);
    }
    
    
}
