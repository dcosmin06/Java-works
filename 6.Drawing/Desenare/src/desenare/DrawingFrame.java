/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenare;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Cosmin
 */
public class DrawingFrame extends JFrame {
    private Toolbar tool;
    private ControlPanel controlPanel;
    private Canvas myCanvas;
    
    public DrawingFrame(String title){
        super(title);
    }
    
    public void setup(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        tool = new Toolbar(this);
        this.getContentPane().add(tool, BorderLayout.NORTH);
        myCanvas = new Canvas();
        this.getContentPane().add(myCanvas, BorderLayout.CENTER);
        controlPanel = new ControlPanel();
        controlPanel.setup();
        controlPanel.setCanvas(myCanvas);
        this.getContentPane().add(controlPanel, BorderLayout.SOUTH);
    }
    
    public Canvas getCanvas(){
        return myCanvas;
    }
}
