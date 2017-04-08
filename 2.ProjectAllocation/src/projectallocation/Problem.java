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
public class Problem {
    /**
     * private atributes of this class which contain the number of students
     * and projects and the lists with this students and projects
     */
    private int studentsNumber;
    private int projectsNumber;
    private ArrayList studentsList = new ArrayList();
    private ArrayList projectsList = new ArrayList();
    
    /**
     *
     * @param sNumber 1st argument of constructor, represents the number of students
     * @param pNumber 2nd argument of constructor, represents the number of projects 
     */
    public Problem(int sNumber, int pNumber)
    {
        studentsNumber=sNumber;
        projectsNumber=pNumber;
    }
    
    /**
     *
     * @param args list of objects of type Student
     * the method stores the list in ArrayList studentsList
     */
    public void setStudents(Student ... args)
    {
        for(int i=0; i < args.length; i++)
            studentsList.add(args[i]);
    }
    
    /**
     *
     * @param args list of objects of type Projects
     * the method stores the list in ArrayList projectsList
     */
    public void setProjects(Project ... args)
    {
        for(int i=0; i < args.length; i++)
            projectsList.add(args[i]);
    }
    
    /**
     *
     * @return a new ArrayList which contain the list of students
     * stored by this object of type Problem
     */
    public ArrayList getStudents()
    {
        ArrayList temp = new ArrayList();
        for(int i=0; i < studentsList.size(); i++)
            temp.add(studentsList.get(i));
        return temp;
    }
    
    /**
     *
     * @return a new ArrayList which contain the list of projects
     * stored by this object of type Problem
     */
    public ArrayList getProjects()
    {
        ArrayList temp = new ArrayList();
        for(int i=0; i < projectsList.size(); i++)
            temp.add(projectsList.get(i));
        return temp;
    }
    
    /**
     * a method that prints on screen the number of students for this
     * Problem instance
     */
    public void getStudentsNumber()
    {
        System.out.println(studentsNumber);
    }
    
    /**
     *a method that prints on screen the number of projects for this
     * Problem instance
     */
    public void getProjectsNumber()
    {
        System.out.println(projectsNumber);
    }
    
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(!(obj instanceof Problem))
            return false;
        Problem p=(Problem)obj;
        if(p.studentsNumber==this.studentsNumber && p.projectsNumber==this.projectsNumber)
            return true;
        return false;
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Student preferences\n");
        for(int i=0; i < studentsList.size(); i++)
        {
            sb.append(studentsList.get(i));
            sb.append(": ( ");
            Student temp = (Student)studentsList.get(i);
            ArrayList tempArray = new ArrayList();
            tempArray = temp.getPreferences();
            for(int j=0; j < tempArray.size(); j++)
            {
                sb.append(tempArray.get(j));
                sb.append(" ");
            }    
            sb.append(")\n");
        }
        sb.append("\n");
        sb.append("Project preferences\n");
        for(int j=0; j < projectsList.size(); j++)
        {
            sb.append(projectsList.get(j));
            sb.append(": ( ");
            Project temp = (Project)projectsList.get(j);
            ArrayList tempArray = new ArrayList();
            tempArray = temp.getPreferences();
            for(int i=0; i < tempArray.size(); i++)
            {
                sb.append(tempArray.get(i));
                sb.append(" ");
            }    
            sb.append(")\n");
        }
        return sb.toString();
    }
    
    
    public void Solver(int n)
    {
        boolean[] studentAllocated = new boolean[n];
        boolean[] projectAllocated = new boolean[n];
        for(int i=0; i < studentAllocated.length; i++)
        {
            studentAllocated[i]=false;
            projectAllocated[i]=false;
        }
        int allocationCount = 0;
        while(allocationCount < n)
        {
            int free;
            for(free = 0; free < n; free++)
            {
                if(studentAllocated[free]==false)
                    break;
            }
            
            for(int k = 0; k < n && !studentAllocated[free]; k++)
            {
                Student s = (Student)studentsList.get(free);
                Project p = (Project)s.getPreferences().get(k);
                if(projectAllocated[k]==false)
                {
                    projectAllocated[k]=true;
                    studentAllocated[free]=true;
                    p.setPartner(s);
                    s.setProject(p);
                    allocationCount++;
                }
                else
                {
                    Student currentStudent = p.getPartner();
                    ArrayList temp = p.getPreferences();
                    int s1 = 0;
                    int s2 = 0;
                    for(int i = 0; i < p.getCapacity(); i++)
                    {
                        if((Student)temp.get(i)==currentStudent)
                            s1 = i;
                        if((Student)temp.get(i)==s)
                            s2 = i;
                    }
                    if(s1 < s2)
                       break;
                    else if(s1 > s2)
                    {
                        p.setPartner(s);
                        s.setProject(p);
                        currentStudent.removeProject();
                        studentAllocated[free]=true;
                        int aux = 0;
                        while(aux < n)
                        {
                            if(currentStudent == studentsList.get(aux))
                            {
                                studentAllocated[aux]=false;
                                break;
                            }    
                            aux++;
                        }
                    }
                }
                
            }
            
        }
        int k = 0;
        while(k < n)
        {
            Student s = (Student)studentsList.get(k);
            Project p = s.getProject();
            s.getName();
            System.out.println(':');
            p.getName();
            System.out.println('\n');
            k++;
        }
        
    }
}
