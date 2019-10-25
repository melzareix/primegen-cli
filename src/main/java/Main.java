import commands.PrimeGeneratorCommand;
import picocli.CommandLine;

public class Main {

  public static void main(String[] args) {
    CommandLine commandLine = new CommandLine(new PrimeGeneratorCommand());
    // case-insensitive algorithm name
    commandLine.setCaseInsensitiveEnumValuesAllowed(true);
    int exitCode = commandLine.execute(args);
    System.exit(exitCode);
  }
}
