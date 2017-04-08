/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Cosmin
 */
public class Rucsac{

    private LinkedList<Item> items = new LinkedList<>();
    private int capacity = 0;

    Rucsac(int value)
    {
        this.capacity = value;
    }

    public LinkedList<Item> getItems() {
        return this.items;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Item... itemList) {
        for(Item s:itemList) {
            if(this.capacity > 0){
                int aux=this.capacity-s.getWeight();
                if(aux < 0)
                {
                    System.out.println("Not enough space for "+s.getName());
                }
                else{
                this.items.add(s);
                this.capacity-=s.getWeight();
                }
            } else System.out.println("Not enough space for "+s.getName());
        }
    }


    private static void order(LinkedList<Item> persons) {

        Collections.sort(persons, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Float x1 = Item.getProfitFactor((Item)o1);
                Float x2 = Item.getProfitFactor((Item)o2);
                int compare = x1.compareTo(x2);

                if (compare != 0) {
                    return compare;
                } else {
                    String x3 = ((Item) o1).getName();
                    String x4 = ((Item) o2).getName();
                    return x3.compareTo(x4);
                }
            }});
    }
    
    
    
    private static void orderValue(LinkedList<Item> persons) {

        Collections.sort(persons, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Integer x1 = ((Item) o1).getValue();
                Integer x2 = ((Item) o2).getValue();
                int compare;
                compare = x1.compareTo(x2);

                if (compare != 0) {
                    return compare;
                } else {
                    String x3 = ((Item) o1).getName();
                    String x4 = ((Item) o2).getName();
                    return x3.compareTo(x4);
                }
            }});
    }
    

    public void order(){
        Rucsac.order(this.items);
    }
    
    public void orderValue(){
        Rucsac.orderValue(this.items);
    }
    
    

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for(int index = 0; index < items.size(); index++){
            Item aux = items.get(index);
            str.append("Item name: " + aux.getName() + " Weight: " + aux.getWeight() + " Value: " + aux.getValue() +  " ProfitFactor: " + Item.getProfitFactor(aux) + "\n");
        }

        return str.toString();
    }

}
