import java.util.*;

public class Josephus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int n = scanner.nextInt();
        System.out.print("Enter the killing interval: ");
        int k = scanner.nextInt();
        scanner.close();

        int survivor = josephus(n, k);
        System.out.println("The survivor is at position: " + survivor);
    }

    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }
}

/*
 Examples
n = 5 and k = 2

The safe position is 3. Firstly, the person at position 2 is killed, then person
at position 4 is killed, then person at position 1 is killed. Finally, the person at
position 5 is killed. So the person at position 3 survives

n = 7 and k = 3

The safe position is 4. The persons at positions 3, 6, 2, 7, 5, 1 are killed in
order, and person at position 4 survives
 */