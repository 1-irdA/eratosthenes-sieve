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
     * Array of prime numbers wrapper
     */
    private final PrimeWrapper primeWrapper;

    /**
     * Initialize Benchmark to compute execution time
     * @param eratosthenes to search prime numbers
     * @param wrapper contains primes number
     */
    public Benchmark(Eratosthenes eratosthenes, PrimeWrapper wrapper) {
        sieve = eratosthenes;
        primeWrapper = wrapper;
    }

    /**
     * Launch one benchmarking test, launch concurrent or simple
     * Eratosthenes sieve following parameters
     * @param concurrent if true, launch concurrent sieve
     * @param display if true, display prime numbers
     */
    public void launchUnique(boolean concurrent, boolean display) {
        long start = System.currentTimeMillis();

        if (concurrent) {
            sieve.quickSieve();
        } else {
            sieve.sieve();
        }

        long duration = System.currentTimeMillis() - start;

        if (display) {
            primeWrapper.displayPrimeNumbers();
        }

        /*
         * Init primes for other tests
         */
        primeWrapper.init();

        System.out.printf("""
            -------------------------
            Max number : %d
            Concurrent : %b
            Duration   : %d ms
            """,
                primeWrapper.getMaxLimit(),
                concurrent,
                duration);
    }
}
