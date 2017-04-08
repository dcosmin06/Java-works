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
public class Movie extends MediaItem{
    private static final long serialVersionUID = 22776147L;
    
    public Movie(String name, String path, int year){
        if(year < 0 || year > 2017)
            throw new CustomException("Invalid year", year);
        this.name = name;
        this.path = path;
        this.year = year;
    }
    
    
    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("Movie: ");
        temp.append(this.name +"  ");
        temp.append("Year of release: "+this.year+"\n");
        temp.append("Local path: "+this.path+"\n");
        return temp.toString();
    }
}
