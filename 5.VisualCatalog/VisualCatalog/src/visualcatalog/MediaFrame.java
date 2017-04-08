/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualcatalog;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Cosmin
 */
public class MediaFrame extends JFrame{
    
    
    public MediaFrame(String title){
        super(title);
    }
    
    public void configureFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        CatalogList list = new CatalogList();
        ItemForm form = new ItemForm(list);
        form.configure();
        this.getContentPane().add(form, BorderLayout.NORTH);
        ControlPanel panel = new ControlPanel(form);
        panel.configure();
        this.getContentPane().add(list, BorderLayout.CENTER);
        this.getContentPane().add(panel, BorderLayout.SOUTH);
        this.pack();
    }
    
}
