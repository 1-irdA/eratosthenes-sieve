package _1irdA.eratosthene.models;

import static _1irdA.eratosthene.utils.SieveUtils.filter;

/**
 * Task class to find prime numbers concurrently
 */
public class Task extends Thread {

    /**
     * Multiples to set at false
     */
    private final int position;

    /**
     * Array who define if an number is a primer number
     * The prime number is represented with the index
     */
    private final boolean[] primes;

    /**
     * Initialize Task
     * @param multiple multiple to set at false
     * @param array array who define if a number is a primer number
     */
    public Task(int multiple, boolean[] array) {
        position = multiple;
        primes = array;
    }

    @Override
    public void run() {
        filter(primes, position);
    }
}
