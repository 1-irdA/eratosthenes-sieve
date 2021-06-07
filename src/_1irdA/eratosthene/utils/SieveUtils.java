package _1irdA.eratosthene.utils;

/**
 * SieveUtils contains one method to filter
 * prime number
 */
public class SieveUtils {

    /**
     * Filter prime number with index of array
     * Filter with a step of (1 + multiple % 2) * multiple
     * to not filter on pair values because there already set at false
     * with filter multiples of 2, divide time by 2.
     * Example :
     * With 2 : 2 * 2 = 4, 4 + 1 * 2 = 6, 6 + 1 * 2 = 8
     * With 3 : 3 * 3 = 9, 9 + 2 * 3 = 15, 15 + 2 * 3 = 21
     * @param primes array who define if a number is a prime number
     * @param multiple multiple to set at false
     */
    public static void filter(boolean[] primes, int multiple) {
        int step = (1 + multiple % 2) * multiple;
        for (int position = multiple * multiple;
                position > 0 && position < primes.length;
                position += step) {
            primes[position] = false;
        }
    }
}
