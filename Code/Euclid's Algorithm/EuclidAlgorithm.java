import java.util.Scanner;
public class EuclidAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter values for a and b
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();
        // Calculate and print the GCD using the Euclidean algorithm
        int result = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " = " + result);
        scanner.close();
    }
    // Recursive function to calculate the GCD using the Euclidean algorithm
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
