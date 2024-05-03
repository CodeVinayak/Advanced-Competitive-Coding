import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncrementalSieve {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the limit (n): ");
        int n = scanner.nextInt();
        scanner.close();

        List<Integer> primes = incrementalSieve(n);
        System.out.print("Prime numbers up to " + n + ": ");
        printPrimes(primes);
    }

    public static List<Integer> incrementalSieve(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        if (n >= 2) {
            primes.add(2);
            isPrime[2] = true;
        }

        for (int num = 3; num <= n; num += 2) {
            boolean isPrimeNum = true;
            for (int prime : primes) {
                if (prime * prime > num) {
                    break;
                }
                if (num % prime == 0) {
                    isPrimeNum = false;
                    break;
                }
            }
            if (isPrimeNum) {
                primes.add(num);
                isPrime[num] = true;
            }
        }

        return primes;
    }

    public static void printPrimes(List<Integer> primes) {
        for (int i = 0; i < primes.size(); i++) {
            System.out.print(primes.get(i));
            if (i != primes.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
