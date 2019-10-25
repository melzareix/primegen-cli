package algos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MillerRabinAlgorithmTest {
  MillerRabinAlgorithm millerRabinAlgorithm;

  @Before
  public void initializeClass() {
    millerRabinAlgorithm = new MillerRabinAlgorithm();
  }

  @Test
  public void testBaseCases() {
    boolean isNegativePrime = millerRabinAlgorithm.isPrime(-1);
    boolean isOnePrime = millerRabinAlgorithm.isPrime(1);
    boolean isTwoPrime = millerRabinAlgorithm.isPrime(2);
    boolean isEvenPrime = millerRabinAlgorithm.isPrime(100);

    // first base case
    assertFalse(isNegativePrime);
    assertFalse(isOnePrime);

    // second base case
    assertTrue(isTwoPrime);

    // third base case
    assertFalse(isEvenPrime);
  }

  @Test
  public void testFirstTenPrimesGenerator() {
    int[] firstTenPrimes = {
        2, 3, 5, 7, 11, 13, 17, 19, 23
    };

    ArrayList<Integer> primes = millerRabinAlgorithm.generatePrimes(0, 25);
    assertEquals(firstTenPrimes.length, primes.size());

    for (int i = 0; i < firstTenPrimes.length; i++) {
      assertEquals(primes.get(i).intValue(), firstTenPrimes[i]);
    }
  }

  @Test
  public void testRangeGenerator() {
    int[] correctPrimes = {
        11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
    };

    ArrayList<Integer> primes = millerRabinAlgorithm.generatePrimes(10, 50);
    assertEquals(correctPrimes.length, primes.size());

    for (int i = 0; i < correctPrimes.length; i++) {
      assertEquals(primes.get(i).intValue(), correctPrimes[i]);
    }
  }

  @Test
  public void testLargeRangeGenerator() {
    ArrayList<Integer> primes = millerRabinAlgorithm.generatePrimes(2, (int)(1e6));
    assertEquals(78498, primes.size());
  }
}