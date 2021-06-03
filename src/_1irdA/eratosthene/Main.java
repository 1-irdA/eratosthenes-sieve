package _1irdA.eratosthene;

import _1irdA.eratosthene.models.Benchmark;
import _1irdA.eratosthene.models.Eratosthenes;
import _1irdA.eratosthene.models.PrimeWrapper;

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

        benchmark.launchUnique(true,false,false,false);
        benchmark.launchUnique(true,true,false,false);
        benchmark.launchUnique(true,false,true,false);
        benchmark.launchUnique(false,false,false,false);
        benchmark.launchUnique(false,false,true,false);
    }
}
