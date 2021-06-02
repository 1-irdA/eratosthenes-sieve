package _1irdA.eratosthene.tests;

import _1irdA.eratosthene.models.PrimeWrapper;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPrimeWrapper {

    @Test
    public void testInitEratosthenes() {
        PrimeWrapper primeWrapper = new PrimeWrapper(100);

        primeWrapper.init();

        boolean[] primesArr = primeWrapper.getPrimeNumbers();

        assertTrue(IntStream.range(2, primesArr.length)
                .allMatch(index -> primesArr[index]));
    }

    @Test
    public void testInitWithInvalidLimit() {
        assertThrows(IllegalArgumentException.class, () -> new PrimeWrapper(Integer.MAX_VALUE));
    }
}
