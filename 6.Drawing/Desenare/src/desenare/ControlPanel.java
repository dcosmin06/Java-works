/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenare;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Cosmin
 */
public class ControlPanel extends JPanel {
    private Canvas auxCanvas;
    private JLabel auxContainer;
    
    public ControlPanel(){
        super();
    }
    
    public void setCanvas(Canvas canvas){
        auxCanvas = canvas;
    }
    
    public void setup(){
        JButton loadButton = new JButton("Load");
        JButton saveButton = new JButton("Save");
        JButton resetButton = new JButton("Reset");
        this.add(loadButton);
        this.add(saveButton);
        this.add(resetButton);
        
        
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auxCanvas.graphics.setBackground(new Color(0,0,0,0));
                auxCanvas.graphics.clearRect(0,0,auxCanvas.image.getWidth(), auxCanvas.image.getHeight());
                auxContainer = new JLabel(new ImageIcon(auxCanvas.image));
                auxCanvas.imageContainer = auxContainer;
            }
        });
        
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File outputfile = new File("image.jpg");
                try {
                    ImageIO.write(auxCanvas.image, "jpg", outputfile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
    }
    
}
