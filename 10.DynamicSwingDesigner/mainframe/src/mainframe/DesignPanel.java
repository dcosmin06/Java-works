/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.awt.Dimension;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Cosmin
 */
public class DesignPanel extends JPanel{
    public static final int W=800;
    public static final int H=600;
    private final Mainframe frame;
    
    public DesignPanel(Mainframe frame){
        this.frame = frame;
        setPreferredSize(new Dimension(W,H));
        setLayout(null);
    }
    
    
    public void addAtRandomLocation(JComponent comp){
        int x = ThreadLocalRandom.current().nextInt(0,W);
        int y = ThreadLocalRandom.current().nextInt(0,H);
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
    
}