import java.util.Scanner;
public class StrobogrammaticNumber {
    // Function to check if the given number is strobogrammatic
    public static boolean isStrobogrammatic(String num) {
        // Define strobogrammatic pairs (digit pairs that look the same when rotated)
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            boolean isValidPair = false;
            for (char[] pair : pairs) {
                if (pair[0] == leftChar && pair[1] == rightChar) {
                    isValidPair = true;
                    break;
                }
            }
            if (!isValidPair) {
                return false; // Not a valid strobogrammatic pair
            }
            left++;
            right--;
        }
        return true; // All characters form valid strobogrammatic pairs
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt user to enter a number
        System.out.print("Enter a number to check if it is strobogrammatic: ");
        String num = scanner.next();
        // Check if the entered number is strobogrammatic
        boolean isStrobogrammatic = isStrobogrammatic(num);
        // Print the result
        if (isStrobogrammatic) {
            System.out.println(num + " is strobogrammatic.");
        } else {
            System.out.println(num + " is not strobogrammatic.");
        }
        scanner.close();
    }
}
