import java.util.Scanner;
public class StrobogrammaticNumberChecker {
    public static boolean isStrobogrammatic(String num) {
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            boolean found = false;
            for (char[] pair : pairs) {
                if (pair[0] == l && pair[1] == r) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String num = scanner.nextLine();
        System.out.println(num + " " + isStrobogrammatic(num));
        scanner.close();
    }
}