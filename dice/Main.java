package dice;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random RNG = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many sides does the die have?");
        int n = scanner.nextInt();
        System.out.println("Try all values?");
        boolean tryAll = scanner.nextBoolean();
        final double nPlusOneOverTwo = ((double)n + 1) / 2;
        if (!tryAll) {
            int numRollsSoFar = 0;
            int j = 0;
            int i;
            while (true) {
                i = j;
                j = RNG.nextInt(n) + 1;
                System.out.println("Roll " + numRollsSoFar + ": " + j);
                numRollsSoFar++;

                //exit checking
                if (j <= i && i < nPlusOneOverTwo) {
                    System.out.println("Exited by case A: j<=i<(n+1)/2");
                    break;
                }
                if (j >= i && i >= nPlusOneOverTwo) {
                    System.out.println("Exited by case B: j>=i>=(n+1)/2");
                    break;
                }
            }
        } else {
            int workingCases = 0;
            int totalCases = 0;
            String[] tableau = new String[n];
            boolean[][] doesCaseWorkArray = new boolean[n][n];
            for (int I = 1; I <= n; I++) {
                int thisIWorkingCases = 0;
                for (int J = 1; J <=n; J++) {
                    if (J <= I && I < nPlusOneOverTwo) {
                        System.out.println("Behold: "+J+"<="+I+"<"+nPlusOneOverTwo+" (Case A)");
                        workingCases++;
                        thisIWorkingCases ++;
                        doesCaseWorkArray[I-1][J-1] = true;
                    } else if (J >= I && I >= nPlusOneOverTwo) {
                        System.out.println("Behold: "+J+">="+I+">="+nPlusOneOverTwo+" (Case B)");
                        workingCases++;
                        thisIWorkingCases++;
                        doesCaseWorkArray[I-1][J-1] = true;
                    }
                    totalCases++;
                }
                tableau[I-1] = "If the first number is "+I+", there are "+thisIWorkingCases+" cases that work.";
            }
            for (int I = 0; I < n; I++) {
                for (int J = 0; J < n; J++) {
                    if (doesCaseWorkArray[I][J]) {
                        System.out.print("\u001b[38;2;0;255;0m");
                    } else {
                        System.out.print("\u001b[38;2;255;0;0m");
                    }
                    if (I < 9) {
                        System.out.print((I + 1) + "  " + (J + 1) + ": " + doesCaseWorkArray[I][J]);
                    } else {
                        System.out.print((I + 1) + " " + (J + 1) + ": " + doesCaseWorkArray[I][J]);
                    }
                    if (doesCaseWorkArray[I][J]) {
                        System.out.print(" ");
                    }
                    System.out.print("\u001b[0m | ");
                }
                System.out.print("\n");
            }
            for (String item : tableau) {
                System.out.println(item);
            }
            System.out.print("("+(double)workingCases/(double)totalCases+")\n");

            System.out.println(workingCases + " cases out of "+ totalCases +" cases worked.");

        }

        scanner.close();
    }
}
