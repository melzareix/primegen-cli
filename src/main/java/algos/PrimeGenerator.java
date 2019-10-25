package algos;

import java.util.ArrayList;

public interface PrimeGenerator {

  /**
   * Generate all the primes in the closed range [l,r].
   * @param l the start of the range.
   * @param r the end of the range.
   * @return Array of primes in the closed range [l,r].
   */
  ArrayList<Integer> generatePrimes(int l, int r);
}
