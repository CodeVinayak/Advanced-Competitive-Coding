import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortedUniquePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        List<String> permutations = findPermutations(str);
        System.out.println("Sorted Unique Permutations:");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
        scanner.close();
    }

    public static List<String> findPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutations("", str, permutations);
        Collections.sort(permutations);
        return permutations;
    }

    private static void generatePermutations(String current, String remaining, List<String> permutations) {
        if (remaining.isEmpty()) {
            permutations.add(current);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char c = remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(current + c, newRemaining, permutations);
        }
    }
}