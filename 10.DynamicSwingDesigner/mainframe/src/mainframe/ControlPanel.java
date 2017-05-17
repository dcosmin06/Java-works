/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cosmin
 */
public class ControlPanel extends JPanel{
    private final Mainframe frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");
    
    public ControlPanel(Mainframe frame){
        this.frame = frame;
        init();
    }
    
    
    private void init(){
        this.add(classNameLabel);
        this.add(classNameField);
        this.add(textLabel);
        this.add(textField);
        this.add(createButton);
        
        createButton.addActionListener(e -> {
            JComponent comp = null;
            try {
                comp = createDynamicComponent(classNameField.getText(), textField.getText());
            } catch (InvocationTargetException ex) {
                System.err.println(ex);
            }
            frame.designPanel.addAtRandomLocation(comp);
        });
    }
    
    
    private JComponent createDynamicComponent(String className, String text) throws InvocationTargetException{
        Class auxClass;
        JComponent auxComp = null;
        try {
             auxClass = Class.forName(className);
             Class[] signature = new Class[]{String.class};
             Constructor constr = auxClass.getConstructor(signature);
             auxComp = (JComponent)constr.newInstance(text);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
            System.err.println(ex);
        }
        return auxComp;
    }
    
    
    
}
