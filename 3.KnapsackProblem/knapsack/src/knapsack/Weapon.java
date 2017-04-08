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
public class Weapon extends AbstractItem implements Item{

    Weapon(String name, int weight, int value){
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWeight(int weight){
        this.weight = weight;
    }

    @Override
    public void setValue(int value){
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int getValue(){
        return this.value;
    }
}
