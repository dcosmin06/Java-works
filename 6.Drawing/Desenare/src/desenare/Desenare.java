/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenare;

/**
 *
 * @author Cosmin
 */
public class Desenare {

  
    public static void main(String[] args) {
        DrawingFrame frame = new DrawingFrame("Drawing");
        frame.pack();
        frame.setVisible(true);
        frame.setup();
        
    }
    
}
