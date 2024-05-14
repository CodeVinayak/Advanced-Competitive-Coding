import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        String longestPalindrome = longestPalindrome(input);
        System.out.println("Longest palindrome in the input string: " + longestPalindrome);
        scanner.close();
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        // Check all possible substrings
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substr = s.substring(i, j);
                if (substr.length() > longest.length() && isPalindrome(substr)) {
                    longest = substr;
                }
            }
        }

        return longest;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}