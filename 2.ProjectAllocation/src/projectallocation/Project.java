package projectallocation;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cosmin
 */
public class Project {
    /**
     * private atributes of the class, which contain the
     * project's name, capacity and a list of students preferences
     */
    private String name;
    private int capacity;
    private ArrayList preferences = new ArrayList();
    private String status;
    private ArrayList Partner = new ArrayList();
    
    /**
     *
     * @param name - 1st argument for constructor
     * @param capacity -2nd argument for constructor
     */
    public Project(String name, int capacity)
    {
        this.name=name;
        this.capacity=capacity;
    }
    
    /**
     *
     * @param args - list of arguments for this method
     */
    public void setPreferences(Student ... args)
    {
        for(int i=0; i < args.length; i++)
            preferences.add(args[i]);
    }
    
    /**
     *
     * @return an ArrayList with the project's preferences among the students
     */
    public ArrayList getPreferences()
    {
        ArrayList temp = new ArrayList();
        for(int i=0; i < preferences.size(); i++)
            temp.add(preferences.get(i));
        return temp;
    }
    
    /**
     * prints the name of project
     */
    public void getName()
    {
        System.out.println(name);
    }
    
    /**
     * prints the capacity of project
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(!(obj instanceof Project))
            return false;
        Project p=(Project)obj;
        if(preferences.size() != p.preferences.size())
            return false;
        else
        {
            for(int i=0; i < preferences.size(); i++)
            {
                if(preferences.get(i) != p.preferences.get(i))
                    return false;
            }
            return true;
        }
    }
    
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
    
    public void setPartner(Student s)
    {
        Partner.add(s);
    }
    
    
    public Student getPartner()
    {
        int index=0;
        return (Student)Partner.get(index);
    }
    
}
