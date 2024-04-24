import java.util.Scanner;
public class MaxEquilibriumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxSum = findMaxSum(arr, size);
        System.out.println("The maximum equilibrium sum is: " + maxSum);
        scanner.close();
    }

    static int findMaxSum(int[] arr, int n) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int prefix_sum = arr[i];
            for (int j = 0; j < i; j++) {
                prefix_sum += arr[j];
            }
            int suffix_sum = arr[i];
            for (int j = n - 1; j > i; j--) {
                suffix_sum += arr[j];
            }
            if (prefix_sum == suffix_sum) {
                res = Math.max(res, prefix_sum);
            }
        }
        return res;
    }
}