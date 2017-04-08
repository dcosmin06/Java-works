/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacatalog;

import java.io.*;
import java.awt.Desktop;

/**
 *
 * @author Cosmin
 */
public class Catalog implements java.io.Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    private MediaItem[] catalogItems = new MediaItem[20];
    private int i;
    
    public Catalog(){
        i = 0;
    }
    
    public void add(MediaItem item){
        catalogItems[i] = item;
        i++;
    }
    
    public void list(){
        for(int j = 0; j < i; j++) {
            System.out.println(catalogItems[j]);
        }
    }
    
    
    public void save(String location){
        try{
            FileOutputStream fileOut = new FileOutputStream(location);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.flush();
            fileOut.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public Catalog load(String location){
        Catalog object = null;
        try{
            FileInputStream fileIn = new FileInputStream(location);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = (Catalog)in.readObject(); 
            in.close();
            fileIn.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException c){
            System.out.println("Catalog class not found.");
            c.printStackTrace();
        }
        return object;
    }
    
    
    public void play(String location){
        File file = new File(location);
       try{ if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop class not supported.");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        if(file.exists())
            desktop.open(file);
        else
            throw new CustomException("Invalid path", location);
       }catch(IOException e){
           e.printStackTrace();
       }catch(IllegalArgumentException a){
           System.out.println("File doesn't exist.");
       }
       
    }
    
    
    public MediaItem[] getItems(){
        return catalogItems;
    }
    
    public int getSize(){
        return i;
    }
}
