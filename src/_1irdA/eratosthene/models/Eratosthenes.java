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
     * Wrapper for boolean array who represent
     * prime numbers with array index
     */
    private final PrimeWrapper primes;

    /**
     * Initialize Eratosthenes
     * @param primesArr array to apply eratosthenes sieve
     */
    public Eratosthenes(PrimeWrapper primesArr) {
        primes = primesArr;
    }

    /**
     * Search all prime numbers with multi threads
     */
    public void quickSieve() {
        ArrayList<Task> tasks = new ArrayList<>();
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);

        for (int number = 3; number < max; number += 2) {
            if (primesArr[number]) {
                Task task = new Task(number, primesArr);
                task.start();
                tasks.add(task);
            }
        }

        for (Task task : tasks) {
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Search all prime numbers with multi threads
     * and functional programming
     */
    public void functionalQuickSieve() {
        ArrayList<Task> tasks = new ArrayList<>();
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);

        IntStream.iterate(3, number -> number += 2)
                .limit((long) max)
                .filter(number -> primesArr[number])
                .mapToObj(number -> new Task(number, primesArr))
                .forEach(task -> {
                    task.start();
                    tasks.add(task);
                });

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
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);

        for (int number = 3; number < max; number += 2){
            if (primesArr[number]) {
                filter(primesArr, number);
            }
        }
    }

    /**
     * Search prime numbers with single thread
     * and functional programming
     */
    public void functionalSieve() {
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);

        IntStream.iterate(3, number -> number += 2)
                .limit((long) max)
                .filter(number -> primesArr[number])
                .forEach(number -> filter(primesArr, number));
    }
}
