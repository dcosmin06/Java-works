/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualcatalog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import mediacatalog.Catalog;
import mediacatalog.MediaItem;

/**
 *
 * @author Cosmin
 */
public class ControlPanel extends JPanel {
    
    ItemForm auxForm = new ItemForm();
    
    public ControlPanel(){
        super();
    }
    
    public ControlPanel(ItemForm form){
        auxForm = form;
    }
    
    public void configure(){
        JButton playButton = new JButton("play");
        JButton loadButton = new JButton("load");
        JButton saveButton = new JButton("save");
        this.add(playButton);
        this.add(loadButton);
        this.add(saveButton);
        
        saveButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                Catalog auxCatalog = auxForm.getCatalog();
                auxCatalog.save("E:\\fisier.ser");
            }
        });
        
        
        loadButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                Catalog auxCatalog = new Catalog();
                Catalog c = new Catalog();
                c = auxCatalog.load("E:\\fisier.ser");
                c.list();
                CatalogList auxList = auxForm.getCatalogList();
                MediaItem[] items = c.getItems();
                for(int i=0; i < c.getSize(); i++){
                   String str = items[i].getName()+" "+items[i].getPath()+" "+items[i].getYear()+" ";
                   auxList.addItem(str);
                }
            }
        });
        
        
        playButton.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e){
                CatalogList auxList = auxForm.getCatalogList();
                String str = (String) auxList.getSelectedValue();
                String result = str.substring(str.indexOf("[")+1, str.indexOf("]"));
                Catalog auxCatalog = new Catalog();
                auxCatalog.play(result);
            }
        });
    }
    
}
