package _1irdA.eratosthene.tests;

import _1irdA.eratosthene.models.Eratosthenes;
import _1irdA.eratosthene.models.PrimeWrapper;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEratosthenes {

    private static final int NB_PRIME_NUMBERS_UNDER_ONE_HUNDRED = 25;

    private static final int NB_PRIME_NUMBERS_UNDER_TEN_THOUSAND = 1229;

    @Test
    public void testSieveOneHundred() {
        PrimeWrapper primeWrapper = new PrimeWrapper(100);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.sieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        assertEquals(NB_PRIME_NUMBERS_UNDER_ONE_HUNDRED,
                IntStream.range(0, primesArr.length)
                .filter(number -> primesArr[number])
                .count());
    }

    @Test
    public void testQuickSieveOneHundred() {
        PrimeWrapper primeWrapper = new PrimeWrapper(100);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.quickSieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        assertEquals(NB_PRIME_NUMBERS_UNDER_ONE_HUNDRED,
                IntStream.range(0, primesArr.length)
                .filter(number -> primesArr[number])
                .count());
    }

    @Test
    public void testQuickSieveTenThousand() {
        PrimeWrapper primeWrapper = new PrimeWrapper(10000);
        Eratosthenes eratosthenes = new Eratosthenes(primeWrapper);

        primeWrapper.init();
        eratosthenes.quickSieve();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        assertEquals(NB_PRIME_NUMBERS_UNDER_TEN_THOUSAND,
                IntStream.range(0, primesArr.length)
                        .filter(number -> primesArr[number])
                        .count());
    }
}
