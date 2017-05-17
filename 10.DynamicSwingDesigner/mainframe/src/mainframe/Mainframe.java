/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Cosmin
 */
public class Mainframe extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    
    public Mainframe(){
        super("Swing Designer");
        init();
    }
    
    
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);
        this.getContentPane().add(controlPanel, BorderLayout.NORTH);
        this.getContentPane().add(designPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    
    public static void main(String[] args) {
        Mainframe mf = new Mainframe();
    }
    
}
