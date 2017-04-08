/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualcatalog;

import mediacatalog.Catalog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mediacatalog.MediaItem;
import mediacatalog.Movie;

/**
 *
 * @author Cosmin
 */
public class ItemForm extends JPanel {
    CatalogList auxList = new CatalogList();
    Catalog catalog = new Catalog();
    
    public ItemForm(){
        super();
        setLayout(new BorderLayout());
    }
    
    public ItemForm(CatalogList auxList){
        super();
        setLayout(new BorderLayout());
        this.auxList = auxList;
        this.setBorder(BorderFactory.createTitledBorder("Add media item"));
    }
    
    public void configure(){
        JLabel nameLabel = new JLabel("Name");
        JLabel pathLabel = new JLabel("Path");
        JLabel yearLabel = new JLabel("Year");
        JTextField firstText = new JTextField(10);
        JTextField secondText = new JTextField(15);
        JSpinner yearField = new JSpinner(new SpinnerNumberModel(2000, 1900, 2017, 1));
        
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                String aux = firstText.getText()+' '+secondText.getText()+' '+yearField.getValue();
                auxList.addItem(aux);
                Movie movie = new Movie(firstText.getText(), secondText.getText(), (int) yearField.getValue());
                catalog.add((MediaItem)movie);
                firstText.setText(" ");
                secondText.setText(" ");
            }
        });
        ItemForm auxForm1 = new ItemForm();
        auxForm1.setLayout(new BorderLayout());
        auxForm1.add(nameLabel, BorderLayout.NORTH);
        auxForm1.add(firstText, BorderLayout.CENTER);
        auxForm1.add(pathLabel, BorderLayout.SOUTH);
        
        ItemForm auxForm2 = new ItemForm();
        auxForm2.setLayout(new BorderLayout());
        auxForm2.add(secondText, BorderLayout.NORTH);
        auxForm2.add(yearLabel, BorderLayout.CENTER);
        auxForm2.add(yearField, BorderLayout.SOUTH);
        
        this.add(auxForm1, BorderLayout.NORTH);
        this.add(auxForm2, BorderLayout.CENTER);
        this.add(addButton, BorderLayout.SOUTH);
    }
    
    public Catalog getCatalog(){
        return this.catalog;
    }
    
    public CatalogList getCatalogList(){
        return this.auxList;
    }

   
}
