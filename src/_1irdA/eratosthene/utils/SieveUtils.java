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
     * 2 * 2 = 4, 4 + 2 = 6, 6 + 2 = 8
     * 3 * 3 = 9, 9 + 3 = 12, 12 + 3 = 15
     * @param primes array who define if a number is a prime number
     * @param multiple multiple to set at false
     */
    public static void filter(boolean[] primes, int multiple) {
        for (int position = multiple * multiple; position > 0 && position < primes.length; position += multiple) {
            primes[position] = false;
        }
    }
}
