package _1irdA.eratosthene;

import _1irdA.eratosthene.models.Benchmark;
import _1irdA.eratosthene.models.Eratosthenes;

/**
 * Test class
 */
public class Main {

    /**
     * Launch benchmark
     * @param args unused
     */
    public static void main(String[] args) {
        Eratosthenes sieve = new Eratosthenes(Integer.MAX_VALUE - 2);
        Benchmark benchmark = new Benchmark(sieve);

        benchmark.launch(true, false);
    }
}
