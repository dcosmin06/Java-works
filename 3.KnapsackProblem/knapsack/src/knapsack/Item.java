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
public interface Item {
    
        void setName(String name);
        void setWeight(int weight);
        void setValue(int value);
        String getName();
        int getWeight();
        int getValue();

        static float getProfitFactor(Item obj) {
            float x1 = (float) obj.getValue();
            float x2 = (float) obj.getWeight();
                return x1 / x2;
        }
}
