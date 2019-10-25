package commands;

import algos.LinearSieveAlgorithm;
import algos.MillerRabinAlgorithm;
import algos.PrimeGenerator;
import algos.SieveAlgorithm;
import algos.TrialDivision;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * Parse the inputs from command line and process it.
 */
@Command(
    name = "prime-generator",
    description = "Generate prime numbers in a range using several algorithms."
)
public class PrimeGeneratorCommand implements Callable<Integer> {

  enum Algorithms {
    TrialDivision,
    MillerRabin,
    Sieve,
    LinearSieve
  }

  @Option(
      names = {"-a", "--algorithm"},
      description = "Algorithm to use for generation",
      required = true
  )
  Algorithms algorithm;

  @Option(
      names = {"-s", "--start"},
      description = "Lower bound of the range",
      required = true
  )
  int start;

  @Option(
      names = {"-e", "--end"},
      description = "Upper bound of the range",
      required = true
  )
  int end;

  /**
   * Initialize the algorithm based on input.
   */
  private PrimeGenerator selectAlgorithm() {
    PrimeGenerator primeGenerator;
    switch (algorithm) {
      case Sieve:
        primeGenerator = new SieveAlgorithm();
        break;
      case LinearSieve:
        primeGenerator = new LinearSieveAlgorithm();
        break;
      case MillerRabin:
        primeGenerator = new MillerRabinAlgorithm();
        break;
      default:
        primeGenerator = new TrialDivision();
    }
    return primeGenerator;
  }

  /**
   * Print a nicely formatted list of primes.
   */
  private void printResults(ArrayList<Integer> primes) {
    System.out.println("======================================================");
    System.out.println(primes.size() + " primes found in the range " + start + " to " + end +".");
    System.out.println("======================================================");
    for (int i = 0; i < primes.size(); i++) {
      System.out.printf("%-10d", primes.get(i));
      if ((i + 1) % 10 == 0) {
        System.out.println();
      }
    }
    System.out.println();
    System.out.println("======================================================");
  }

  public Integer call() throws Exception {
    PrimeGenerator primeGenerator = selectAlgorithm();
    ArrayList<Integer> primes = primeGenerator.generatePrimes(start, end);
    printResults(primes);
    return 0;
  }


}
