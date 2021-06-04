package _1irdA.eratosthene.models;

/**
 * Benchmark class to compute execution time
 * of Eratosthenes sieve with mono thread
 * and multi thread
 */
public class Benchmark {

    /**
     * Describe benchmark options
     */
    private static final String[] OPTIONS = {
            "Runnable quick sieve",
            "Functional and runnable quick sieve",
            "Quick sieve",
            "Functional quick sieve",
            "Sieve",
            "Functional sieve"
    };

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
     * @param option option to launch sieve
     *                   0 -> Runnable quick sieve
     *                   1 -> Functional and runnable quick sieve
     *                   2 -> Quick sieve
     *                   3 -> Functional quick sieve
     *                   4 -> Sieve
     *                   5 -> Functional sieve
     * @param display if true, display prime numbers
     */
    public void launchUnique(int option, boolean display) {
        long start = System.currentTimeMillis();

        switch (option) {
            case 0 -> sieve.runnableQuickSieve();
            case 1 -> sieve.functionalRunnableQuickSieve();
            case 2 -> sieve.quickSieve();
            case 3 -> sieve.functionalQuickSieve();
            case 4 -> sieve.sieve();
            case 5 -> sieve.functionalSieve();
        }

        long duration = System.currentTimeMillis() - start;

        if (display) {
            primeWrapper.display();
        }

        /*
         * Init primes for other tests
         */
        primeWrapper.init();

        System.out.printf("""
            -------------------------
            Max number : %d
            Option     : %s
            Duration   : %d ms
            """,
                primeWrapper.getMaxLimit(),
                OPTIONS[option],
                duration);
    }
}
