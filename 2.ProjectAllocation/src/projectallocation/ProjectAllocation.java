/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectallocation;

/**
 *
 * @author Cosmin
 */
public class ProjectAllocation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Problem problem = new Problem(4,3);
        Student s1 = new Student("S1","s1@info.uaic.ro");
        Student s2 = new Student("S2","s2@info.uaic.ro");
        Student s3 = new Student("S3","s3@info.uaic.ro");
        Student s4 = new Student("S4","s4@info.uaic.ro");
        Project p1 = new Project("P1",2);
        Project p2 = new Project("P2",1);
        Project p3 = new Project("P3",1);
        s1.setPreferences(p1,p2,p3);
        s2.setPreferences(p1,p3,p2);
        s3.setPreferences(p1);
        s4.setPreferences(p3,p2,p1);
        p1.setPreferences(s3,s1,s2,s4);
        p2.setPreferences(s1,s2,s3,s4);
        p3.setPreferences(s4,s3,s1,s2);
        
        problem.setStudents(s1,s2,s3,s4);
        problem.setProjects(p1,p2,p3);
        
      /*  System.out.println(problem);*/
      problem.Solver(3);
        
        
       
        
    }
    
}
