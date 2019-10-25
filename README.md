# SimScale PrimeGenerator CLI

### Problem Statement
Please provide us with a concise, efficient and robust prime number generator written in Java/Scala/Go that gives all prime numbers in the range between two numbers provided by the user (e.g. user gives 1 and 10 and you return "2, 3, 5, 7").

### How to run

1. Make sure `jdk 8+` and `maven` are installed.
2. Clone this repo.
3. Run `mvn test` to run the tests.
4. Run `mvn package -DskipTests` to generate a fat jar.
5. Run the generated jar `java -jar PATH_TO_JAR args` where args explained below.

### Arguments

1. `-a, --algorithm=<algorithm> Algorithm to use for generation`

Available Algorithms

    1. TrialDivision
    2. MillerRabin
    3. Sieve
    4. LinearSieve

2. `-e, --end=<end>       Upper bound of the range`
3. `-s, --start=<start>   Lower bound of the range`