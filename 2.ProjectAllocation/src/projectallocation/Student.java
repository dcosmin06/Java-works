/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallocation;

import java.util.*;

/**
 *
 * @author Cosmin
 */
public class Student {
    /**
     * private atributes of the class, which contain
     * the student's name, email address and a list with
     * project preferences
     * 
     */
    private String name;
    private String email;
    private ArrayList preferences = new ArrayList();
    private String status;
    private ArrayList project = new ArrayList();
    
    /**
     *
     * @param name -1st argument of constructor
     * @param email -2nd argument of constructor
     * 
     */
    public Student(String name, String email) /* constructor pt student */
    {
        this.name=name;
        this.email=email;
    }
    
    /**
     *
     * @param args -list of arguments for this method
     * this method sets a student's preferences order of the
     * available projects in the ArrayList preferences.
     */
    public void setPreferences(Project ... args)
    {
        for(int i=0; i < args.length; i++)
            preferences.add(args[i]);   
    }
    
    /**
     *
     * @return an ArrayList with student's preferences from the
     * available projects
     */
    public ArrayList getPreferences()
    {
        ArrayList temp = new ArrayList();
        for(int i=0; i < preferences.size(); i++)
            temp.add(preferences.get(i));
        return temp;
    }
    
    /**
     * returns the name of the student
     */
    public void getName()
    {
        System.out.println(this.name);
    }
    
    /**
     * returns the address of the student
     */
    public void GetEmail()
    {
        System.out.println(this.email);
    }
    
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(!(obj instanceof Student))
            return false;
        Student s=(Student)obj;
        if(preferences.size() != s.preferences.size())
            return false;
        else
        {
            for(int i=0; i < preferences.size(); i++)
            {
                if(preferences.get(i) != s.preferences.get(i))
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
    
    
    public void setProject(Project p)
    {
        project.add(p);
        
    }
    
    
    public Project getProject()
    {
        int index=0;
        return (Project)project.get(index);
    }
    
    
    public void removeProject()
    {
        int index=0;
        project.remove(index);
    }
}
