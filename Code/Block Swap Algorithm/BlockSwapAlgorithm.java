public class BlockSwapAlgorithm {
    // Function to rotate an array to the left by 'd' positions using block swap algorithm
    static void rotateLeft(int[] arr, int d) {
        int n = arr.length;
        d %= n; // To handle cases where d is greater than the array length
        if (d == 0) return; // No rotation needed
        reverse(arr, 0, d - 1); // Reverse the first d elements
        reverse(arr, d, n - 1); // Reverse the remaining elements
        reverse(arr, 0, n - 1); // Reverse the entire array
    }

    // Function to reverse elements in the array from index 'start' to 'end'
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to print an array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2; // Number of positions to rotate left
        System.out.println("Original array:");
        printArray(arr);
        rotateLeft(arr, d);
        System.out.println("Array after rotating left by " + d + " positions:");
        printArray(arr);
    }
}
