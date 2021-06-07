package _1irdA.eratosthene.models;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

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

    /**
     * Filter prime number with index of array
     * Filter with a step of (1 + multiple % 2) * multiple
     * to not filter on pair values because there already set at false
     * with filter multiples of 2, divide time by 2.
     * Example :
     * With 2 : 2 * 2 = 4, 4 + 1 * 2 = 6, 6 + 1 * 2 = 8
     * With 3 : 3 * 3 = 9, 9 + 2 * 3 = 15, 15 + 2 * 3 = 21
     * @param primes array who define if a number is a prime number
     * @param multiple multiple to set at false
     */
    public static void filter(boolean[] primes, int multiple) {
        int step = (1 + multiple % 2) * multiple;
        for (int position = multiple * multiple;
             position > 0 && position < primes.length;
             position += step) {
            primes[position] = false;
        }
    }
}
