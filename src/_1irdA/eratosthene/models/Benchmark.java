package _1irdA.eratosthene.models;

/**
 * Benchmark class to compute execution time
 * of Eratosthenes sieve with mono thread
 * and multi thread
 */
public class Benchmark {

    /**
     * Eratosthenes sieve
     */
    private final Eratosthenes sieve;

    /**
     * Initialize Benchmark to compute execution time
     * @param eratosthenes object to search prime numbers
     */
    public Benchmark(Eratosthenes eratosthenes) {
        sieve = eratosthenes;
    }

    /**
     * Launch benchmarking
     * @param concurrent if true, launch multi thread method
     * @param displayNumbers if true, display prime numbers
     */
    public void launch(boolean concurrent, boolean displayNumbers) {
        long start = System.currentTimeMillis();

        if (concurrent) {
            sieve.quickSieve();
        } else {
            sieve.sieve();
        }

        long duration = System.currentTimeMillis() - start;

        if (displayNumbers) {
            sieve.display();
        }

        System.out.println("Sieve duration : " + duration + " ms");
    }
}
