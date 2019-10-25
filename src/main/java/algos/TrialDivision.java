package algos;

import java.util.ArrayList;

/**
 * Generate primes in the closed range [l,r] using Trial Division Algorithm.
 */
public class TrialDivision implements PrimeGenerator {

  /**
   * Check if number is prime by trial division division.
   *
   * Time Complexity: O(sqrt(N))
   *
   * https://en.wikipedia.org/wiki/Trial_division
   *
   * @param n the number to check for primality.
   * @return whether the number is prime or not.
   */
  boolean isPrime(int n) {

    // negative numbers, 0 or 1 aren't prime by definition
    if (n <= 1) {
      return false;
    }

    // 2 is prime
    if (n == 2) {
      return true;
    }

    // if the number is even it can't be prime
    if (n % 2 == 0) {
      return false;
    }

    /*
      loop for all odd numbers from [3, sqrt(n)] repeatedly checking
      if n is divisible by that number then n isn't prime.
     */
    for (int i = 3; i * i <= n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Generate all the primes in the closed range [l,r].
   *
   * Time Complexity: O(N * Sqrt(r)) where N is the number of elements in the range [l,r] and r is
   * the largest number in the range.
   *
   * @param l the start of the range.
   * @param r the end of the range.
   * @return Array of primes in the closed range [l,r].
   */
  public ArrayList<Integer> generatePrimes(int l, int r) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int i = l; i <= r; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }
}
