package algos;

import java.util.ArrayList;

public class LinearSieveAlgorithm implements PrimeGenerator {

  ArrayList<Integer> primes;
  ArrayList<Integer> resultPrimes;

  /**
   * Preprocess numbers till N using the Linear Sieve of Eratosthenes algorithm. Time Complexity:
   * O(N)
   *
   * Algorithm: https://cp-algorithms.com/algebra/prime-sieve-linear.html
   *
   * @param N the maximum range to preprocess.
   */
  void preprocess(int L, int N) {
    primes = new ArrayList<Integer>();

    // save the final results if the primes are in range
    // to save a loop at the end
    resultPrimes = new ArrayList<Integer>();

    // assume all numbers are prime
    int[] minPrimeFactor = new int[N + 1];

    for (int i = 2; i <= N; ++i) {
      // if number is prime add it to primes array
      // and result array if in range
      // set its minimum prime factor to itself
      if (minPrimeFactor[i] == 0) {
        primes.add(i);
        if (i >= L) {
          resultPrimes.add(i);
        }
        minPrimeFactor[i] = i;
      }
      // update the minPrimeFactor array
      for (int prime : primes) {
        if (prime > minPrimeFactor[i] || prime * i > N) {
          break;
        } else {
          minPrimeFactor[prime * i] = i;
        }
      }
    }
  }


  /**
   * Generate all the primes in the closed range [l,r]. Time Complexity: O(R) where
   * R is the end number of the range.
   *
   * @param l the start of the range.
   * @param r the end of the range.
   * @return Array of primes in the closed range [l,r].
   */
  public ArrayList<Integer> generatePrimes(int l, int r) {
    preprocess(l, r);
    return resultPrimes;
  }
}
