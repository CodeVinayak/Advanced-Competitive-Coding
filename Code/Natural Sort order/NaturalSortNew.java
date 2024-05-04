import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NaturalSortNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] array = new String[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextLine();
        }
        Arrays.sort(array, new NaturalOrderComparator());
        System.out.println("Sorted array:");
        for (String element : array) {
            System.out.println(element);
        }
        scanner.close();
    }
    static class NaturalOrderComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String[] parts1 = s1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            String[] parts2 = s2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

            int minSize = Math.min(parts1.length, parts2.length);
            for (int i = 0; i < minSize; i++) {
                if (!parts1[i].equals(parts2[i])) {
                    if (parts1[i].matches("\\d+") && parts2[i].matches("\\d+")) {
                        return Integer.compare(Integer.parseInt(parts1[i]), Integer.parseInt(parts2[i]));
                    } else {
                        return parts1[i].compareTo(parts2[i]);
                    }
                }
            }
            return Integer.compare(parts1.length, parts2.length);
        }
    }
}