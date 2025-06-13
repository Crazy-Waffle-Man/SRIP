package java_project;

public class LinearScanner {
    public static double[][][] partition(double[][] points, int[] partitionSizes) {
        //initialize the array with differently sized sub-arrays
        double[][][] partitionedPoints = new double[partitionSizes.length][][];
        for (int i = 0; i < partitionSizes.length; i++) {
            partitionedPoints[i] = new double[partitionSizes[i]][2];
        }

        int startingIndex = 0;

        for (int i = 0; i < partitionedPoints.length; i++) {
            int partitionSize = partitionSizes[i]; // Get current partition size
            for (int j = 0; j < partitionSize; j++) {
                partitionedPoints[i][j] = points[startingIndex + j]; // Copy elements
            }
            startingIndex += partitionSize; // Move to next slice
        }
        return partitionedPoints;
    }

    public static double[][] sortByY(double[][] points) {
        double[][] sortedPoints = points.clone(); // Clone to avoid modifying the original array

        int n = sortedPoints.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedPoints[j][1] > sortedPoints[j + 1][1]) {
                    double[] temp = sortedPoints[j];
                    sortedPoints[j] = sortedPoints[j + 1];
                    sortedPoints[j + 1] = temp;
                }
            }
        }
        return sortedPoints;
    }
}
