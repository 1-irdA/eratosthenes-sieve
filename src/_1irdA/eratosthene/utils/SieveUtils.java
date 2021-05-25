package _1irdA.eratosthene.utils;

/**
 * SieveUtils contains one method to filter
 * prime number
 */
public class SieveUtils {

    /**
     * Filter prime number with index of array
     * Filter with n * n + n
     * Example :
     * 2 * 2, 4 + 2, 6 + 2
     * 3 * 3, 6 + 3, 9 + 3
     * @param primes array who define if a number is a prime number
     * @param multiple multiple to set at false
     */
    public static void filter(boolean[] primes, int multiple) {
        for (int position = multiple * multiple; position < primes.length; position += multiple) {
            primes[position] = false;
        }
    }
}
