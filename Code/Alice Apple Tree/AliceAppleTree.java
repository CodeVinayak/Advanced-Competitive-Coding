import java.util.*;

public class AliceAppleTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int apple = sc.nextInt(); // Get the desired number of apples from the user
        sc.close();
        int cnt = 0, sum = 0;

        // Loop to find the minimum number of trees needed
        while (sum < apple) {
            cnt++;
            sum += (12 * cnt * cnt); // Calculate the total apples for the current number of trees
        }

        System.out.println((8 * (cnt))); // Print the minimum number of trees needed
    }
}