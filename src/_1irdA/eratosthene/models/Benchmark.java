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
     * Launch benchmarking
     * @param concurrent if true, launch multi thread method
     * @param functional if true, launch functional method
     * @param displayNumbers if true, display prime numbers
     */
    public void launchUnique(boolean concurrent, boolean functional, boolean displayNumbers) {
        long start = System.currentTimeMillis();

        if (concurrent && functional) {
            sieve.functionalQuickSieve();
        } else if (concurrent) {
            sieve.quickSieve();
        } else if (functional) {
            sieve.functionalSieve();
        } else {
            sieve.sieve();
        }

        long duration = System.currentTimeMillis() - start;

        if (displayNumbers) {
            primeWrapper.display();
        }

        /*
         * Init primes for other tests
         */
        primeWrapper.init();

        System.out.printf("""
            ----------------
            Max number : %d
            Concurrent : %b
            Functional : %b
            Display    : %b
            Duration   : %d ms
            """,
                primeWrapper.getMaxLimit(),
                concurrent,
                functional,
                displayNumbers,
                duration);
    }
}
