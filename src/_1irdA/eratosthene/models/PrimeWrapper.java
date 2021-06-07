package _1irdA.eratosthene.models;

import java.util.stream.IntStream;

import static _1irdA.eratosthene.models.Eratosthenes.filter;

/**
 * Wrapper class who represent all primes
 * number between [0, Integer.MAX_VALUE - 2]
 */
public class PrimeWrapper {

    /**
     * Contains boolean to define if number is
     * a prime number or not
     * Array index represent the number
     * Array max size <= Integer.MAX_VALUE - 2
     */
    private final boolean[] primeNumbers;

    /**
     * Initialize state object
     * @param maxSize primes array max size
     *                and max number to find
     *                prime numbers
     * @throws IllegalStateException if maxSize > Integer.MAX_VALUE - 2
     */
    public PrimeWrapper(int maxSize) {
        if (maxSize > Integer.MAX_VALUE - 2) {
            throw new IllegalArgumentException("Size needs to be lower or equal than 2147483645");
        }
        primeNumbers = new boolean[maxSize];
    }

    /**
     * Initialize the array who defines if a number is a primer number
     * following is index
     * Initialize [2, primes.length[, 0 and 1 are not prime numbers
     */
    public void init() {
        IntStream.range(2, primeNumbers.length)
                .forEach(index -> primeNumbers[index] = true);

        /*
         * Remove multiples of 2
         */
        filter(primeNumbers, 2);
    }

    /**
     * Display prime numbers
     */
    public void displayPrimeNumbers() {
        IntStream.range(2, primeNumbers.length)
                .filter(number -> primeNumbers[number])
                .forEach(System.out::println);
    }

    public boolean[] getPrimeNumbers() {
        return primeNumbers;
    }

    public int getMaxLimit() {
        return primeNumbers.length;
    }
}
