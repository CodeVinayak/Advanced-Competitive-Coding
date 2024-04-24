public class EulerPhiAlgorithm {
    static int phi(int n) {
        // Initialize the result with n
        int result = n;

        // Iterate from 2 to the square root of n
        for (int p = 2; p * p <= n; ++p) {
            // Check if n is divisible by p
            if (n % p == 0) {
                // If n is divisible by p, divide n by p until it is no longer divisible
                while (n % p == 0)
                    n /= p;

                // Update the result by subtracting the count of numbers divisible by p
                result -= result / p;
            }
        }

        // If n is greater than 1, it means n is a prime number
        // We subtract the count of numbers divisible by n from the result
        if (n > 1)
            result -= result / n;

        // Return the Euler's totient function value for the given number
        return result;
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(phi(n)); // Output: 400
    }
}