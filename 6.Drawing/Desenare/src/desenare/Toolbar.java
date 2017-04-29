/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenare;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


/**
 *
 * @author Cosmin
 */
public class Toolbar extends JPanel {
    private DrawingFrame dframe;
    
    public Toolbar(){
        super();
    }
    
    public Toolbar(DrawingFrame drawingFrame){
        JLabel sideLabel = new JLabel("Sides");
        JLabel shapeLabel = new JLabel("Shapes");
        JLabel strokeLabel = new JLabel("Stroke");
        JTextField sideText = new JTextField(5);
        JTextField shapeText = new JTextField(5);
        JTextField strokeText = new JTextField(5);
        JButton drawButton = new JButton("Draw");
        
        dframe = drawingFrame;
        
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();

                dframe.getCanvas().setStroke(Integer.parseInt(strokeText.getText()));
                dframe.getCanvas().drawShapeAt(
                        random.nextInt(600),
                        random.nextInt(600),
                        Integer.parseInt(shapeText.getText()),
                        Integer.parseInt(sideText.getText()));
            }
        });
        
        this.add(sideLabel);
        this.add(sideText);
        this.add(shapeLabel);
        this.add(shapeText);
        this.add(strokeLabel);
        this.add(strokeText);
        this.add(drawButton);
 
    }
    
    
    
    
    
}
