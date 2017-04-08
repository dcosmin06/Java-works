/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacatalog;

import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author Cosmin
 */
public abstract class MediaItem implements java.io.Serializable {
    protected String name;
    protected String path;
    protected int year;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public int getYear(){
        return this.year;
    }
        
}
