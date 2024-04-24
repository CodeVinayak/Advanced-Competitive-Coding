import java.util.Scanner;
public class SimpleSieve {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        boolean[] bool = new boolean[num];
        
        // Set all elements to true initially
        for (int i = 0; i < bool.length; i++) {
            bool[i] = true;
        }
        
        // Sieve of Eratosthenes algorithm to find prime numbers
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (bool[i] == true) {
                for (int j = i * i; j < num; j = j + i) {
                    bool[j] = false;
                }
            }
        }
        sc.close();
        System.out.println("List of prime numbers up to the given number are: ");
        for (int i = 2; i < bool.length; i++) {
            if (bool[i] == true) {
                System.out.println(i);

            }
        }
    }
}