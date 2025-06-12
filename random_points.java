//Dylan Kavde
//6/12/2025
//Program will take points and rotate it such that a horizontal partition can be made to definitely take away that split of points. Random points will be created.
import helpers.helperMethods;
import java.util.Scanner;
import java.util.Arrays;


public class MyProgram
{
    public static void main(String[] args)
    {
      /*switch (value) {
          case (9) {
              
          }
      }*/
      
      //Initialize scanner
       Scanner scanner = new Scanner(System.in);
       
       //Find amount of points wanted to be tested
       System.out.println("How many points does thou want");
        int n = scanner.nextInt();
        double[][] points = new double[n][2];
        
        //Fills array points with random numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++){
            points[i][j] =  10*Math.random();
            }
        }
        
        points = helperMethodes.randomPoints(n);
        /*for (double[] point : points) {
            System.out.println(Arrays.toString(point));
        }*/
       
        
    }
    
    
}
