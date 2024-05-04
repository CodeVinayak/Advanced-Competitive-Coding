import java.util.*;

public class NaturalSort3 {
    // Comparator for natural string sorting
    static Comparator<String> naturalOrderComparator = new Comparator<String>() {
        @Override
        public int compare(String str1, String str2) {
            return compareNatural(str1, str2);
        }
    };

    // Method to compare two strings naturally
    static int compareNatural(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {
            char char1 = str1.charAt(index1);
            char char2 = str2.charAt(index2);
            if (Character.isDigit(char1) && Character.isDigit(char2)) {
                // Both characters are digits, compare as numbers
                int num1 = 0;
                int num2 = 0;
                // Build number from str1
                while (index1 < len1 && Character.isDigit(str1.charAt(index1))) {
                    num1 = num1 * 10 + (str1.charAt(index1) - '0');
                    index1++;
                }
                // Build number from str2
                while (index2 < len2 && Character.isDigit(str2.charAt(index2))) {
                    num2 = num2 * 10 + (str2.charAt(index2) - '0');
                    index2++;
                }
                // Compare the numeric parts
                if (num1 != num2) {
                    return Integer.compare(num1, num2);
                }
            } else {
                // Compare characters lexicographically
                if (char1 != char2) {
                    return Character.compare(char1, char2);
                }
                index1++;
                index2++;
            }
        }
        // Handle cases where one string is a prefix of the other
        if (index1 < len1) {
            return 1; // str1 is longer
        } else if (index2 < len2) {
            return -1; // str2 is longer
        } else {
            return 0; // Both strings are equal
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        // Input array elements
        String[] strings = new String[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            strings[i] = scanner.nextLine();
        }
        // Sort the array using natural order comparator
        Arrays.sort(strings, naturalOrderComparator);
        // Print the sorted array
        System.out.println("Sorted strings in natural order:");
        for (String str : strings) {
            System.out.println(str);
        }
        scanner.close();
    }
}
