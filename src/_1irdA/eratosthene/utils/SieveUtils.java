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
     * With 2 : 2 * 2 = 4, 4 + 1 * 2 = 6, 6 + 1 * 2 = 8
     * With 3 : 3 * 3 = 9, 9 + 2 * 3 = 15, 15 + 2 * 3 = 21
     * @param primes array who define if a number is a prime number
     * @param multiple multiple to set at false
     */
    public static void filter(boolean[] primes, int multiple) {
        for (int position = multiple * multiple;
                position > 0 && position < primes.length;
                position += (1 + multiple % 2) * multiple) {
            primes[position] = false;
        }
    }
}
