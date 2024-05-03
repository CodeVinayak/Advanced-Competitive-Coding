import java.util.*;

public class Combination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        scanner.close();

        long result = calculateCombination(n, k);
        System.out.println("Combination (n choose k) is: " + result);
    }

    public static long calculateCombination(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            // Use Pascal's triangle recurrence relation: C(n, k) = C(n-1, k-1) + C(n-1, k)
            return calculateCombination(n - 1, k - 1) + calculateCombination(n - 1, k);
        }
    }
}
