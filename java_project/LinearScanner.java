package java_project;

public class LinearScanner {
    public static double[][][] partition(double[][] points, int[] partitionSizes) {
        //initialize the array with differently sized sub-arrays
        double[][][] partitionedPoints = new double[partitionSizes.length][][];
        for (int i = 0; i < partitionSizes.length; i++) {
            partitionedPoints[i] = new double[partitionSizes[i]][2];
        }


        for (int i = 0; i < partitionedPoints.length; i++) {
            for (int j = 0; j < partitionedPoints[i].length; j++) {
                partitionedPoints[i][j] = points[j]; // set the partitioned version of the points array
            }
        }
        return partitionedPoints;
    }

    public static double[][] sortByY(double[][] points) {
        double[][] sortedPoints = new double[points.length][2];

        for (int i = 0; i < points.length; i++) {
            
        }

        return sortedPoints;
    }
}
