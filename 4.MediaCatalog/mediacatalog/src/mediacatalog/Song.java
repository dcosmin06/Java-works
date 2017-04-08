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
public class Song extends MediaItem{
    private static final long serialVersionUID = 47L;
    private String artist;
    
    Song(String name, String artist, String path, int year){
        if(year < 0 || year > 2017)
            throw new CustomException("Invalid year", year);
        this.name = name;
        this.artist = artist;
        this.path = path;
        this.year = year;
    }
    
    
    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("Song: ");
        temp.append(this.name +"  ");
        temp.append("Artist: ");
        temp.append(this.artist +"  ");
        temp.append("Year of release: "+this.year+"\n");
        temp.append("Local path: "+this.path+"\n");
        return temp.toString();
    }
    
}
