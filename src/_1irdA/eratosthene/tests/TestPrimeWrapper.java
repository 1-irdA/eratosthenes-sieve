package _1irdA.eratosthene.tests;

import _1irdA.eratosthene.models.PrimeWrapper;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPrimeWrapper {

    @Test
    public void testInitEratosthenesCheckEvenValues() {
        PrimeWrapper primeWrapper = new PrimeWrapper(100);

        primeWrapper.init();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * check if even values are set to false with
         * init(), begin with 3 because 2 is a prime number
         */
        assertTrue(IntStream.range(3, primesArr.length)
                .filter(index -> index % 2 == 0)
                .allMatch(index -> !primesArr[index]));
    }

    @Test
    public void testInitEratosthenesCheckOddValues() {
        PrimeWrapper primeWrapper = new PrimeWrapper(100);

        primeWrapper.init();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        /*
         * check if odd values are set to true
         */
        assertTrue(IntStream.range(2, primesArr.length)
                .filter(index -> index % 2 != 0)
                .allMatch(index -> primesArr[index]));
    }

    @Test
    public void testInitWithInvalidLimit() {
        assertThrows(IllegalArgumentException.class, () -> new PrimeWrapper(Integer.MAX_VALUE));
    }
}
