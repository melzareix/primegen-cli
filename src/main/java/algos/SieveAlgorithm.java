package algos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Generate primes in the closed range [l,r] with Sieve of Eratosthenes Algorithm.
 */
public class SieveAlgorithm implements PrimeGenerator {

  boolean[] isPrime;

  /**
   * Preprocess numbers till N using the Sieve of Eratosthenes algorithm. Time Complexity: O(N log
   * log sqrt(N))
   *
   * Algorithm: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
   *
   * @param N the maximum range to preprocess.
   */
  void preprocess(int N) {
    isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true);
    // initialize array, [0,1] are not primes
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= N; ++i) {
      if (isPrime[i]) {
        if ((long) i * i <= N) {
          // mark all multiples of i as not primes.
          for (int j = i * i; j <= N; j += i) {
            isPrime[j] = false;
          }
        }
      }
    }

  }

  /**
   * O(1) check if number n is prime.
   *
   * @param n the number to check for primality.
   * @return whether the number is prime or not.
   */
  boolean isPrime(int n) {
    if (n < 0) return false;
    return isPrime[n];
  }

  /**
   * Generate all the primes in the closed range [l,r]. Time Complexity: O(R log log sqrt(R)) where
   * R is the end number of the range.
   *
   * @param l the start of the range.
   * @param r the end of the range.
   * @return Array of primes in the closed range [l,r].
   */
  public ArrayList<Integer> generatePrimes(int l, int r) {

    /*
     Generate the sieve till R, since this is a cli and user won't reuse
     the results it's okay for production its better to preprocess and cache the results
     till N i.e (1e7) and then answer queries in O(1).
     */
    preprocess(r);

    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int i = l; i <= r; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }
}
