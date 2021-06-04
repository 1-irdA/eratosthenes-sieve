package _1irdA.eratosthene;

import _1irdA.eratosthene.models.Benchmark;
import _1irdA.eratosthene.models.Eratosthenes;
import _1irdA.eratosthene.models.PrimeWrapper;

import java.lang.reflect.InvocationTargetException;

/**
 * Test class
 */
public class Main {

    /**
     * Launch benchmark
     * @param args unused
     */
    public static void main(String[] args) {

        PrimeWrapper primes = new PrimeWrapper(Integer.MAX_VALUE - 2);
        Eratosthenes sieve = new Eratosthenes(primes);
        Benchmark benchmark = new Benchmark(sieve, primes);

        primes.init();

        benchmark.launchUnique(0,false);
        benchmark.launchUnique(1,false);
        benchmark.launchUnique(2,false);
        benchmark.launchUnique(3,false);
        benchmark.launchUnique(4,false);
        benchmark.launchUnique(5,false);
    }
}
