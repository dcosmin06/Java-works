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
public class Mediacatalog {

    public static void main(String[] args) {
       Book b1 = new Book("The Foundation", "E:\\the_foundation.pdf", 1951, "Isaac Asimov");
        Catalog c = new Catalog();
        c.add(b1);
        c.add (new Movie("Game of Thrones", "E:\\got.mp4", 2011));
        c.add (new Song("Lose Yourself","Eminem", "E:\\eminem-lose_yourself.mp3", 2002));
        c.list();
       /* c.save("E:\\fisier.ser");
        Catalog aux = new Catalog();
        Catalog vec = new Catalog();
        vec = aux.load("E:\\fisier.ser");
        vec.list(); */
        c.play("E:\\got.mp4");
        //String aux = b1.getPath();
        //c.play(aux);
        
     
    }
    
}
