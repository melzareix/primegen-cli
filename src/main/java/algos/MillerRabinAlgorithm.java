package algos;

import java.math.BigInteger;
import java.util.ArrayList;


/**
 * Generate primes in the closed range [l,r] using MillerRabin Algorithm.
 */
public class MillerRabinAlgorithm implements PrimeGenerator{

  /**
   * Check if the number n is prime using Miller-Rabin Algorithm.
   * It's a probabilistic algorithm that's builtin Java BigInteger class
   *
   * Time Complexity: O(certainty * log3n)
   *
   * Algorithm:
   * https://cp-algorithms.com/algebra/primality_tests.html#toc-tgt-2
   * @param n the number to check for primality.
   * @return whether the number is prime or not.
   */
  public boolean isPrime(int n) {
    return new BigInteger(String.valueOf(n)).isProbablePrime(8);
  }

  /**
   * Generate all the primes in the closed range [l,r].
   * Time Complexity: O(N * certainty * log3r)
   * where N is the number of elements in the range [l,r]
   * and r is the largest number in the range.
   *
   * @param l the start of the range.
   * @param r the end of the range.
   * @return Array of primes in the closed range [l,r].
   */
  public ArrayList<Integer> generatePrimes(int l, int r) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int i = l; i <= r ; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }
}
