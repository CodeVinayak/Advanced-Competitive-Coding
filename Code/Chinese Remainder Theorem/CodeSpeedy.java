import java.util.Scanner;

public class CodeSpeedy {
    static int chineseRemainderTheorem(int[] a, int[] m, int n, int product) {
        int result = 0;
        int[] M = new int[n]; // Store M values

        for (int i = 0; i < n; i++) {
            M[i] = product / m[i];
        }

        for (int i = 0; i < n; i++) {
            int y;
            for (y = 0; (M[i] * y) % m[i] != 1; y++);
            result = (result + a[i] * M[i] * y) % product;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of congruence relations: ");
        int size = scanner.nextInt();

        int[] a = new int[size];
        System.out.println("Enter the values of rem: ");
        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }

        int[] m = new int[size];
        int product = 1;
        System.out.println("Enter the values of num: ");
        for (int i = 0; i < size; i++) {
            m[i] = scanner.nextInt();
            product *= m[i];
        }

        System.out.println("The solution is " + chineseRemainderTheorem(a, m, size, product));
        scanner.close();
    }
}