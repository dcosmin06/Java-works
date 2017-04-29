/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenare;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Cosmin
 */
public class Canvas extends JPanel {

    BufferedImage image = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = image.createGraphics();
    private int radius;
    private int sides;
    JLabel imageContainer;
    private Stroke currentStroke;
 

    
    Canvas(){
        super();
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Random rand = new Random();
                drawShapeAt(e.getX(),e.getY(), 25, 25);
                repaint();
            }
        });
        
        currentStroke = graphics.getStroke();

        imageContainer = new JLabel(new ImageIcon(image));
        add(imageContainer);
    }
    
    public void setStroke(float stroke) {
        graphics.setStroke(new BasicStroke(stroke));
        currentStroke = graphics.getStroke();
    }
    
    
    
    public void drawShapeAt(int x, int y, int radius, int sides){
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
        graphics.fill(new RegularPolygon(x,y,radius,sides));
        graphics.setStroke(currentStroke);
        repaint();
    }
    
    
    
    
}
