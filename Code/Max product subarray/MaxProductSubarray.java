import java.util.Scanner;

public class MaxProductSubarray {
    // Function to calculate the maximum product of any contiguous subarray
    static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            
            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num);

            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the array elements
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Calculate the maximum product of any contiguous subarray
        int result = maxProduct(nums);

        // Output the maximum product
        System.out.println("Max Product = " + result);

        scanner.close();
    }
}
