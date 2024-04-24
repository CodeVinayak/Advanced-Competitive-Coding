public class KaratsubaAlgorithm {
    public static long karatsuba(long x, long y) {
        // Base case: If either x or y is less than 10, perform simple multiplication
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Calculate the number of digits in x and y
        int n = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
        int halfN = n / 2;

        // Split x and y into two halves
        long xL = x / (long) Math.pow(10, halfN);
        long xR = x % (long) Math.pow(10, halfN);
        long yL = y / (long) Math.pow(10, halfN);
        long yR = y % (long) Math.pow(10, halfN);

        // Recursively calculate the three products
        long p1 = karatsuba(xL, yL);
        long p2 = karatsuba(xR, yR);
        long p3 = karatsuba(xL + xR, yL + yR);

        // Combine the three products
        return p1 * (long) Math.pow(10, 2 * halfN) + (p3 - p1 - p2) * (long) Math.pow(10, halfN) + p2;
    }

    public static void main(String[] args) {
        long x = 123456789;
        long y = 987654321;

        long product = karatsuba(x, y);
        System.out.println("Product: " + product);
    }
}