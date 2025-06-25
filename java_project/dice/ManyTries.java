package java_project.dice;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java_project.dice.ManyTries.*;


public class ManyTries {
    public static int n;
    public static volatile double nPlusOneOverTwo;
    public static long rolls;
    public static int[] totalRolls;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Program Started ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many sides does the die have?");
        n = scanner.nextInt();
        nPlusOneOverTwo = ((double)n+1)/2;

        System.out.println("How many times to roll?");
        rolls = scanner.nextLong();
        totalRolls = new int[Math.toIntExact(rolls)];
        scanner.close();

        //Make the thread pool
        Runnable[] tasks = new Runnable[Math.toIntExact(rolls)];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new RollDie(i); //It does RollDie.run(k);
        } // we have 17 threads
        ExecutorService pool = Executors.newFixedThreadPool(17);
        for (Runnable task : tasks) {
            //do the thingy
            pool.execute(task);
        }
        pool.shutdown();
        //wait for all threads to finish execution, or until 1 hour passes.
        try {
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //take the average
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
        //Play the game. called in line 38
        try {
            System.out.println("Executing thread "+k);
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
            System.out.println("Finished execution of thread "+k+" after "+count+" rolls.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
