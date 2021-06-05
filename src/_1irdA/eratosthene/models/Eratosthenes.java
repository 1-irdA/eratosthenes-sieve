package _1irdA.eratosthene.models;

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
     * and runnable tasks
     */
    public void quickSieve() {
        boolean[] primesArr = primes.getPrimeNumbers();
        double max = Math.sqrt(primesArr.length);
        ExecutorService executor = Executors.newCachedThreadPool();

        /*
         * begin at 3, multiples of 2 already remove in init()
         */
        for (int number = 3; number < max; number += 2) {
            if (primesArr[number]) {
                executor.execute(new SieveTask(primesArr, number));
            }
        }

        executor.shutdown();
        while (!executor.isTerminated());
    }

    /**
     * Search prime numbers with single thread
     * and functional programming
     */
    public void sieve() {
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
