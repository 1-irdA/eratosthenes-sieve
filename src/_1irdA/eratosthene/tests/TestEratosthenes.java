package _1irdA.eratosthene.tests;

import _1irdA.eratosthene.models.Eratosthenes;
import _1irdA.eratosthene.models.PrimeWrapper;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestEratosthenes {

    private static final int NB_PRIME_NUMBERS_UNDER_ONE_HUNDRED = 25;

    private static final int NB_PRIME_NUMBERS_UNDER_TEN_THOUSAND = 1229;

    private static final int NB_PRIME_NUMBERS_UNDER_ONE_MILLION = 78498;

    private static final int NB_PRIME_NUMBERS_UNDER_ONE_HUNDRED_MILLION = 5761455;

    private static final int A_PRIME_NUMBER_UNDER_ONE_HUNDRED = 61;

    private static final int A_PRIME_NUMBER_UNDER_TEN_THOUSAND = 3407;

    private static final int A_PRIME_NUMBER_UNDER_ONE_MILLION = 648709;

    private static final int A_PRIME_NUMBER_UNDER_ONE_HUNDRED_MILLION = 99995747;

    private static final int A_PRIME_NUMBER_UNDER_TWO_BILLIONS = 1000387097;

    private static final int NOT_A_PRIME_NUMBER_UNDER_FIVE_THOUSAND = 4417;


    @Test
    public void testSieveOneHundred() {
        PrimeWrapper primeWrapper = new PrimeWrapper(100);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.sieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * Count the number of prime numbers
         * and compare with the expected value.
         */
        assertEquals(NB_PRIME_NUMBERS_UNDER_ONE_HUNDRED,
                IntStream.range(0, primesArr.length)
                .filter(number -> primesArr[number])
                .count());

        /*
         * Check if sieve algorithm set at true
         * an expected prime number.
         */
        assertTrue(primesArr[A_PRIME_NUMBER_UNDER_ONE_HUNDRED]);
    }


    @Test
    public void testQuickSieveTenThousand() {
        PrimeWrapper primeWrapper = new PrimeWrapper(10000);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.quickSieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * Count the number of prime numbers
         * and compare with the expected value.
         */
        assertEquals(NB_PRIME_NUMBERS_UNDER_TEN_THOUSAND,
                IntStream.range(0, primesArr.length)
                        .filter(number -> primesArr[number])
                        .count());

        /*
         * Check if sieve algorithm set at true
         * an expected prime number.
         */
        assertTrue(primesArr[A_PRIME_NUMBER_UNDER_TEN_THOUSAND]);
    }

    @Test
    public void testQuickSieveOneMillion() {
        PrimeWrapper primeWrapper = new PrimeWrapper(1000000);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.quickSieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * Count the number of prime numbers
         * and compare with the expected value.
         */
        assertEquals(NB_PRIME_NUMBERS_UNDER_ONE_MILLION,
                IntStream.range(0, primesArr.length)
                        .filter(number -> primesArr[number])
                        .count());

        /*
         * Check if sieve algorithm set at true
         * an expected prime number.
         */
        assertTrue(primesArr[A_PRIME_NUMBER_UNDER_ONE_MILLION]);
    }

    @Test
    public void testQuickSieveOneHundredMillion() {
        PrimeWrapper primeWrapper = new PrimeWrapper(100000000);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.quickSieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * Count the number of prime numbers
         * and compare with the expected value.
         */
        assertEquals(NB_PRIME_NUMBERS_UNDER_ONE_HUNDRED_MILLION,
                IntStream.range(0, primesArr.length)
                        .filter(number -> primesArr[number])
                        .count());

        /*
         * Check if sieve algorithm set at true
         * an expected prime number.
         */
        assertTrue(primesArr[A_PRIME_NUMBER_UNDER_ONE_HUNDRED_MILLION]);
    }

    @Test
    public void testQuickSieveOneBillionFive() {
        PrimeWrapper primeWrapper = new PrimeWrapper(1500000000);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.quickSieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * Check if sieve algorithm set at true
         * an expected prime number.
         */
        assertTrue(primesArr[A_PRIME_NUMBER_UNDER_TWO_BILLIONS]);
    }

    @Test
    public void testIfIsNotAPrimeNumber() {
        PrimeWrapper primeWrapper = new PrimeWrapper(5000);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.quickSieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * Check if sieve algorithm set at false
         * a no prime number.
         */
        assertFalse(primesArr[NOT_A_PRIME_NUMBER_UNDER_FIVE_THOUSAND]);
    }
}
