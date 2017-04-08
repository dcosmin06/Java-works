/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacatalog;

/**
 *
 * @author Cosmin
 */
public class CustomException extends RuntimeException {
    private int id;
    private String path;
    
    public CustomException(){
        super();
    }
    
    public CustomException(String message, int id){
        super(message);
        this.id = id;
    }
    
    public CustomException(String message, String path){
        super(message);
        this.path = path;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
    @Override
    public String getMessage(){
        if(id > 0)
            return super.getMessage() + " for ID: " + id;
        return super.getMessage() + " for PATH: " + path;
    }
    
    public int getId(){
        return id;
    }
    
    public String getPath(){
        return path;
    }
    
    
}
