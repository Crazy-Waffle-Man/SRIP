package java_project;

import java.util.Arrays;
import java.util.Scanner;

public class point_rotator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPoints = scanner.nextInt();
        for (int i = 0; i < numPoints; i++) {
            System.out.println("X value of the point: ");
            double mainX = scanner.nextDouble();
            System.out.println("Y value of the point: ");
            double mainY = scanner.nextDouble();
            System.out.println("Theta (degrees): ");
            double mainTheta = scanner.nextDouble();
            System.out.println("The point is " + Arrays.toString(rotatePoint(mainX, mainY, degToRad(mainTheta))));
        }
        scanner.close();
    }
    private static double radToDeg(double theta) {
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
}