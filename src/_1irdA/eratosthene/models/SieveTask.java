package _1irdA.eratosthene.models;

import static _1irdA.eratosthene.models.Eratosthenes.eliminateMultiples;

/**
 * SieveTask class to find prime numbers concurrently
 */
public class SieveTask implements Runnable {

    /**
     * Multiple to set at false
     */
    private final int position;

    /**
     * Array who define if an number is a primer number
     * The prime number is represented with the index
     */
    private final boolean[] primes;

    /**
     * Initialize Task
     * @param primesArr array who define if a number is a primer number
     * @param multiple multiple to set at false
     */
    public SieveTask(boolean[] primesArr, int multiple) {
        primes = primesArr;
        position = multiple;
    }

    @Override
    public void run() {
        eliminateMultiples(primes, position);
    }
}
