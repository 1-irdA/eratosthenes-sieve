package _1irdA.eratosthene.models;

import java.util.stream.IntStream;

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
     * Initialize [3, primes.length[ with a step of 2
     * Initialize only odd values to true because only 2 is a pair prime number
     * 0 and 1 are not prime numbers
     */
    public void init() {
        primeNumbers[2] = true;
        IntStream.range(3, primeNumbers.length)
                .filter(index -> index % 2 != 0)
                .forEach(index -> primeNumbers[index] = true);
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
