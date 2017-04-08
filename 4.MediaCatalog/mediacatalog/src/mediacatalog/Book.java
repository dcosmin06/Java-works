/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacatalog;

import java.nio.file.Path;

/**
 *
 * @author Cosmin
 */
public class Book extends MediaItem{
    private static final long serialVersionUID = 6147L;
    private String author;
    
    Book(String name, String path, int year, String author){
        if(year < 0 || year > 2017)
            throw new CustomException("Invalid year", year);        
        this.name = name;
        this.path = path;
        this.year = year;
        this.author = author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getAuthor(){
        return this.author;
    }
    
    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("Book: ");
        temp.append(this.name +"  ");
        temp.append("Author: " + this.author+"  ");
        temp.append("Year of release: "+this.year+"\n");
        temp.append("Local path: "+this.path+"\n");
        return temp.toString();
    }
}
