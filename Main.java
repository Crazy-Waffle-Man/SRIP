import java_project.LinearScanner;
import java_project.PointRotator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random RNG = new Random();
    public static void main(String[] args) {
        double[][] points = PointRotator.getPointsFromUser();
        while (!PointRotator.checkYValues(points)) {
            for (int i = 0; i < points.length; i++) {
                points[i] = PointRotator.rotatePoint(points[i][0], points[i][1], 1d);
            }
        }
        points = LinearScanner.sortByY(points);
        System.out.println(Arrays.deepToString(LinearScanner.partition(points, randomPartitionSizes(points.length))));
    }

    private static int[] randomPartitionSizes(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (n > 0) {
            int temp = RNG.nextInt(n + 1);
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
[-1.1426396637476532, 1.922075596544176],
[-0.062035052011373715, 3.605017566159969],
[-4.809692281918996, 5.465058110692771],
[-3.1887853643145765, 7.9894710651164615]
],
[],
[],
[
[-1.1426396637476532, 1.922075596544176]
], [], [], [], [
[-1.1426396637476532, 1.922075596544176]
]]
 */