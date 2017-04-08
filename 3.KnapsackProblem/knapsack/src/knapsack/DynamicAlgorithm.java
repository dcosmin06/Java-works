/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.LinkedList;

/**
 *
 * @author Cosmin
 */
public class DynamicAlgorithm implements Algorithm{
    final long startTime = System.nanoTime();
    private Rucsac rucsac;
    private LinkedList<Item> sortedItems = new LinkedList<>();
    private int totalValue=0;
    private int totalWeight;
    
    DynamicAlgorithm(Rucsac knapsack, Item[] availableItems)
    {
        rucsac = knapsack;
        for(Item e : availableItems)
            sortedItems.add(e);
    }
    
    
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    
    @Override
    public void solve()
    {
        totalValue = rucsac.getCapacity();
        int[] weights = new int[sortedItems.size()];
        int[] values = new int[sortedItems.size()];
        for(int i = 0; i < sortedItems.size(); i++)
        {
            weights[i] = sortedItems.get(i).getWeight();
            values[i] = sortedItems.get(i).getValue();
        }
        int[][] matrix = new int[sortedItems.size()][totalValue];
        for(int j = 0; j < totalValue; j++)
            matrix[0][j] = 0;
        
        for(int i = 1; i < sortedItems.size(); i++)
        {
            for(int k = 0; k < totalValue; k++)
            {
                if(weights[i] > k)
                    matrix[i][k] = matrix[i-1][k];
                else
                {
                    int nr1 = matrix[i-1][k];
                    int nr2 = matrix[i-1][k-weights[i]] + values[i];
                    matrix[i][k] = max(nr1,nr2);
                }
                    
            }
        }
        
        final long duration = (System.nanoTime() - startTime)/1000000000;
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Value of selected objects is: "+matrix[sortedItems.size()-1][totalValue-1]);
        System.out.println("Running time is: "+duration+" seconds.");
        System.out.println("Memory consumed: "+memory+" bytes.");
        
        
        
        
    }
}
