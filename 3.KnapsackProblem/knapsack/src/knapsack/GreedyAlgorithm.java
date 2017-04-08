/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.Arrays;
import java.util.LinkedList;
import static knapsack.Item.getProfitFactor;

/**
 *
 * @author Cosmin
 */
public class GreedyAlgorithm implements Algorithm{
    private Rucsac rucsac;
    private LinkedList<Item> sortedItems = new LinkedList<>();
    private int totalValue=0;
    private int totalWeight;
    
    GreedyAlgorithm(Rucsac knapsack, Item[] availableItems)
    {
        rucsac = knapsack;
        for(Item e : availableItems)
            sortedItems.add(e);
    }
    
    
    
    @Override
    public void solve()
    {
        Rucsac auxKnap = new Rucsac(1000);
        totalWeight = rucsac.getCapacity();
        for(Item e : sortedItems)
            auxKnap.add(e);
        auxKnap.orderValue();
       /* System.out.println("auxknap"+auxKnap);*/
        LinkedList<Item> items = new LinkedList<>();
        items = auxKnap.getItems();
        for(int i = items.size()-1; i >= 0; i--)
        {
            if(totalWeight < items.get(i).getWeight())
            {
                System.out.println("Not enough space for "+items.get(i).getName());
                break;
            }
            else
            {
                rucsac.add(items.get(i));
                totalWeight-=items.get(i).getWeight();
                totalValue+=items.get(i).getValue();
            }
        }
        rucsac.orderValue();
        System.out.println(rucsac); 
    }
    
    
}
