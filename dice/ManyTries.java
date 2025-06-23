package dice;

import java.util.Random;
import java.util.Scanner;

import static dice.ManyTries.*;


public class ManyTries {
    public static int i;
    public static int j;
    public static int n;
    public static volatile double nPlusOneOverTwo;
    public static int rolls;
    public static int[] totalRolls;

    public static void main(String[] args) {
        System.out.println("=== Program Started ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many sides does the die have?");
        n = scanner.nextInt();
        j = 0;
        i = 0;
        nPlusOneOverTwo = ((double)n+1)/2;

        System.out.println("How many times to roll?");
        rolls = scanner.nextInt();
        totalRolls = new int[rolls];
        scanner.close();
        Thread[] threads = new Thread[rolls];
        for (int kMain = 0; kMain < rolls; kMain++) {
            threads[kMain] = new Thread(new RollDie(kMain));
            threads[kMain].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
        double average = 0;
        for (int roll : totalRolls) {
//            System.out.println("Behold a number of rolls: "+roll);
            average += roll;
        }
        average /= rolls;
        System.out.println("Average: "+average);
    }
}

class RollDie implements Runnable {
    private final int k;
    private final Random threadRNG = new Random();
    public RollDie(int K) {
        k = K;
    }
    @Override
    public void run() {
        try {
            int count = 0;
            int i;
            int j = 0;
            while (true) {
                i = j;
                j = threadRNG.nextInt(n) + 1;
                count ++;
                //exit checking
                if (j <= i && i < nPlusOneOverTwo) {
//                    System.out.println("Exited by case A: j<=i<(n+1)/2");
                    break;
                }
                if (j >= i && i >= nPlusOneOverTwo) {
//                    System.out.println("Exited by case B: j>=i>=(n+1)/2");
                    break;
                }
            }
            totalRolls[k] = count;
            System.out.println("Thread "+k+" has finished execution after "+count + " rolls");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
