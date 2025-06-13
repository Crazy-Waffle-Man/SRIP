package java_project;//Dylan Kavde
//6/12/2025
//Program will take points and rotate it such that a horizontal partition can be made to definitely take away that split of points. Random points will be created.
import java.util.Random;
import java.util.Scanner;


public class RandomPoints
{
    public static double[][] generateRandomPoints(int n)
    {
      //Initialize scanner
       Scanner scanner = new Scanner(System.in);
       
       //Find amount of points wanted
        double[][] points = new double[n][2];

        //Fills array points with random numbers
        final Random RNG = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = RNG.nextDouble(0, 10);
            }
        }
        return points;
    }
}
