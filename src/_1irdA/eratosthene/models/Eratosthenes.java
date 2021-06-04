package _1irdA.eratosthene.models;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        ArrayList<ThreadTask> tasks = new ArrayList<>();
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);

        /*
         * begin at 3, multiples of 2 already remove in init()
         */
        for (int number = 3; number < max; number += 2) {
            if (primesArr[number]) {
                ThreadTask task = new ThreadTask(number, primesArr);
                task.start();
                tasks.add(task);
            }
        }

        for (ThreadTask task : tasks) {
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
        ArrayList<ThreadTask> tasks = new ArrayList<>();
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);

        /*
         * begin at 3, multiples of 2 already remove in init()
         */
        IntStream.iterate(3, number -> number += 2)
                .limit((long) max)
                .filter(number -> primesArr[number])
                .mapToObj(number -> new ThreadTask(number, primesArr))
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
     * Search all prime numbers with multi threads
     * and runnable tasks
     */
    public void runnableQuickSieve() {
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);
        ExecutorService executor = Executors.newCachedThreadPool();

        /*
         * begin at 3, multiples of 2 already remove in init()
         */
        for (int number = 3; number < max; number += 2) {
            if (primesArr[number]) {
                executor.execute(new RunnableTask(primesArr, number));
            }
        }

        executor.shutdown();
        while (!executor.isTerminated());
    }

    public void functionalRunnableQuickSieve() {
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);
        ExecutorService executor = Executors.newCachedThreadPool();

        /*
         * begin at 3, multiples of 2 already remove in init()
         */
        IntStream.iterate(3, number -> number += 2)
                .limit((long) max)
                .filter(number -> primesArr[number])
                .mapToObj(number -> new RunnableTask(primesArr, number))
                .forEach(executor::execute);

        executor.shutdown();
        while (!executor.isTerminated());
    }

    /**
     * Search prime numbers with single thread
     */
    public void sieve() {
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);

        /*
         * begin at 3, multiples of 2 already remove in init()
         */
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

        /*
         * begin at 3, multiples of 2 already remove in init()
         */
        IntStream.iterate(3, number -> number += 2)
                .limit((long) max)
                .filter(number -> primesArr[number])
                .forEach(number -> filter(primesArr, number));
    }
}
