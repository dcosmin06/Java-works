/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latinsquare;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Cosmin
 */
public class LatinSquare {
    public static final int GREEK=0x03B1;
    public static final int LATIN=0x0041;
    
    
    public static void printMatrix(String[][] matrix, int size){
        for( int i=0; i<size; i++){
           for(int j=0; j<size; j++){
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println(" ");
        }
    }
    
    
    public static void Scanner(){
        Scanner sc = new Scanner(System.in);
        String arg;
        System.out.println("Enter a size");
        arg=sc.nextLine();
        System.out.println("Enter the type of symbols");
        arg=sc.nextLine();
    }
    
    
    public static void createMatrix(int size, int type){
        String[][] matrix=new String[size][size];
        String[] buffer=new String[size];
        for(int i=0; i < size; i++)
        {
            buffer[i]=Character.toString((char)type);
            type++;
        }
        
        for(int k=0; k < size; k++)
            matrix[0][k]=buffer[k];
        
        for(int index=1; index < size; index++)
        {
            int aux=0;
            matrix[index][size-1]=matrix[index-1][0];
            while(aux < size-1)
            {
                matrix[index][aux]=matrix[index-1][aux+1];
                aux++;
            }
        }
        
        printMatrix(matrix,size);
    }
    
    
    public static void generateSquares(int size, int type, int max)
    {
        String[][] matrix=new String[size][size];
        String[] buffer=new String[size];
        int var=1;
        for(int i=0; i < size; i++)
        {
            buffer[i]=Character.toString((char)type);
            type++;
        }
        while(max > 0)
        {
        for(int k=0; k < size; k++)
            matrix[0][k]=buffer[k];
        
        for(int index=1; index < size; index++)
        {
            int aux=0;
            matrix[index][size-1]=matrix[index-1][0];
            while(aux < size-1)
            {
                matrix[index][aux]=matrix[index-1][aux+1];
                aux++;
            }
        }
        printMatrix(matrix,size);
        for(int j=0; j<size; j++)
            buffer[j]=matrix[var][j];
        var++;
        max--;
        }
    }
    
    
    
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int size=3;
        int symbolType=LATIN;
        if(args.length==0)
        {
            createMatrix(size,symbolType);
        }
        if(args.length > 2){
            System.out.println("Too many arguments");
            System.exit(-1);
        }
        if(args.length==2){
            
        size=Integer.parseInt(args[0]);
        
        if(args[1].equals("latin"))
            symbolType=LATIN;
        else if(args[1].equals("greek"))
            symbolType=GREEK;
        else{
            System.out.println("Invalid type");
            System.exit(-1);
        }
        createMatrix(size,symbolType);
        }
        long end=System.currentTimeMillis();
        long totalTime=end-start;
        System.out.println(totalTime); 
        }
}
