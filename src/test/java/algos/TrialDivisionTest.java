package algos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrialDivisionTest {

  TrialDivision trialDivision;

  @Before
  public void initializeClass() {
    trialDivision = new TrialDivision();
  }

  @Test
  public void testBaseCases() {
    boolean isNegativePrime = trialDivision.isPrime(-1);
    boolean isOnePrime = trialDivision.isPrime(1);
    boolean isTwoPrime = trialDivision.isPrime(2);
    boolean isEvenPrime = trialDivision.isPrime(100);

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

    ArrayList<Integer> primes = trialDivision.generatePrimes(0, 25);
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

    ArrayList<Integer> primes = trialDivision.generatePrimes(10, 50);
    assertEquals(correctPrimes.length, primes.size());

    for (int i = 0; i < correctPrimes.length; i++) {
      assertEquals(primes.get(i).intValue(), correctPrimes[i]);
    }
  }

  @Test
  public void testLargeRangeGenerator() {
    ArrayList<Integer> primes = trialDivision.generatePrimes(0, (int)(1e6));
    assertEquals(primes.size(), 78498);
  }
}