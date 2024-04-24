import java.util.Scanner;

public class MoveHyphensToBeginning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        String result = moveHyphensToBeginning(input);
        System.out.println("Result: " + result);
        scanner.close();
    }

    static String moveHyphensToBeginning(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-') {
                result.append(c);
            }
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '-') {
                result.append(c);
            }
        }
        return result.toString();
    }
}