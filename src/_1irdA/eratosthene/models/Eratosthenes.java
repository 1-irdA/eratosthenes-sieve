package _1irdA.eratosthene.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static _1irdA.eratosthene.utils.SieveUtils.filter;

/**
 * Eratosthenes class to find prime numbers
 * with Eratosthenes sieve
 */
public class Eratosthenes {

    /**
     * Max interval value to search
     * prime numbers
     */
    private final int limit;

    /**
     * Contains boolean to define if number is
     * a prime number
     * Array index represent the number
     */
    private final boolean[] primes;

    /**
     * Initialize Eratosthenes
     * @param max max interval value
     */
    public Eratosthenes(int max) {
        limit = max;
        primes = new boolean[max];
        init();
    }

    /**
     * Search all prime numbers with multi threads
     */
    public void quickSieve() {
        ArrayList<Task> tasks = new ArrayList<>();
        double max = Math.sqrt(limit);

        /*
         * Remove multiples of 2
         */
        filter(primes,2);

        for (int number = 3; number < max; number += 2) {
            if (primes[number]) {
                Task task = new Task(number, primes);
                task.start();
                tasks.add(task);
            }
        }

        tasks.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Search prime numbers with single thread
     */
    public void sieve() {
        double max = Math.sqrt(limit);

        /*
         * Remove multiples of 2
         */
        filter(primes, 2);

        for (int number = 3; number < max; number += 2){
            if (primes[number]) {
                filter(primes, number);
            }
        }
    }

    /**
     * Display prime numbers
     */
    public void display() {
        IntStream.range(2, limit).filter(number -> primes[number]).forEach(System.out::println);
    }

    /**
     * Initialize the array who defines if a number is a primer number
     * following is index
     * Initialize [2, primes.length[, 0 and 1 are not prime numbers
     */
    private void init() {
        IntStream.range(2, primes.length).forEach(i -> primes[i] = true);
    }
}
