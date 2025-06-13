package java_project;

import java.util.Scanner;

public class PointRotator {
    public static double radToDeg(double theta) {
        theta /= Math.PI;
        theta *= 180;
        return theta;
    }
    public static double degToRad(double theta) {
        theta /= 180;
        theta *= Math.PI;
        return theta;
    }
    public static double[] rotatePoint(double x, double y, double theta) {
        double newX = x*Math.cos(theta) - y*Math.sin(theta);
        double newY = x*Math.sin(theta) + y*Math.cos(theta);
        return new double[]{newX, newY};
    }

    public static boolean checkYValues(double[][] points) {
        //loop through the points by indexing points.length
        for (int i = 0; i < points.length; i++) {
            //avoid index error by breaking the loop
            if (i == points.length-1) {
                break;
            } else {
                //Get y1 and y2, then check if they are the same.
                // If y1 == y2, then we can't use LinearScanner
                double y1 = points[i][1];
                double y2 = points[i + 1][1];
                if (y1 == y2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double[][] getPointsFromUser() {
        Scanner scanner = new Scanner(System.in);//set up CLI
        System.out.println("How many points do you want to make? ");
        int numPoints = scanner.nextInt();//get n points
        double[][] points = new double[numPoints][2];
        for (int i = 0; i < numPoints; i++) {
            System.out.println("X value of the point: ");
            points[i][0] = scanner.nextDouble();
            System.out.println("Y value of the point: ");
            points[i][1] = scanner.nextDouble();
        }
        scanner.close();
        return points;
    }
}