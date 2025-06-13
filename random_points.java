//Dylan Kavde
//6/12/2025
//Program will take points and rotate it such that a horizontal partition can be made to definitely take away that split of points. Random points will be created.
import java.util.Scanner;
import java.util.Arrays;


public class random_points
{
    public static double[][] generateRandomPoints(int n)
    {
      //Initialize scanner
       Scanner scanner = new Scanner(System.in);
       
       //Find amount of points wanted to be tested
        double[][] points = new double[n][2];
        
        //Fills array points with random numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++){
            points[i][j] =  10*Math.random();
            }
        }
        return points;
    }
}
