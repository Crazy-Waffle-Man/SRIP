import java_project.LinearScanner;
import java_project.PointRotator;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static final Random RNG = new Random();
    public static void main(String[] args) {
        double[][] points = PointRotator.getPointsFromUser();
        while (!PointRotator.checkYValues(points)) {
            for (int i = 0; i < points.length; i++) {
                points[i] = PointRotator.rotatePoint(points[i][0], points[i][1], PointRotator.degToRad(1.0d));
            }
        }

        final double[][][] POINTS = LinearScanner.partition(points, new int[]{3, 4});

        StringBuilder output = new StringBuilder();
        //build output string
        for (double[][] partition : POINTS) {
            for (double[] pair : partition) {
                output.append("(").append(pair[0]).append(", ").append(pair[1]).append(")");
            }
            output.append("\n");
        }
        System.out.println(output.toString().replaceAll("\\)\\(", "), ("));

    }

    private static int[] randomPartitionSizes(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (n > 0) {
            int temp = 0;
            while (temp <3) {
                 temp = RNG.nextInt(n + 1);
            }
            n -= temp;
            arrayList.add(temp);
        }

        Integer[] toReturnJavaLangInteger = arrayList.toArray(arrayList.toArray(new Integer[0]));

        int[] toReturn = new int[toReturnJavaLangInteger.length];
        for (int i = 0; i < toReturnJavaLangInteger.length; i++) {
            toReturn[i] = toReturnJavaLangInteger[i].intValue();
        }


        return toReturn;
    }
}
/*
[
[
[-0.30116867893975674, 1.3817732906760363],
[-0.6023373578795135, 2.7635465813520725],
[-0.062035052011373715, 3.605017566159969],
[-1.7449770216271667, 4.685622177896248],
[-0.6643724098908872, 6.368564147512042],
[-3.4899540432543334, 9.371244355792497]
]
]

 */