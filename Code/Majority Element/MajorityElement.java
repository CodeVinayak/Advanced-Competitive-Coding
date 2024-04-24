public class MajorityElement {
    // Function to find the majority element in the array
    static Integer findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null; // Return null for empty arrays
        }
        int candidate = nums[0]; // Assume the first element as the initial candidate
        int count = 1; // Count of the current candidate
        // Find the majority element candidate using Boyer-Moore Voting Algorithm
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++; // Increment count if the element matches the candidate
            } else {
                count--; // Decrement count if the element is different from the candidate
            }
            // If count becomes zero, update the candidate to the current element
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        // Verify if the candidate is the majority element by counting its occurrences
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        // If the candidate appears more than n/2 times, it's the majority element; otherwise, return null
        if (count > nums.length / 2) {
            return candidate;
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        Integer result1 = findMajorityElement(arr1);
        System.out.println("Majority Element: " + (result1 != null ? result1 : "null")); // Output: 4
        int[] arr2 = {3, 3, 4, 2, 4, 4, 2, 4};
        Integer result2 = findMajorityElement(arr2);
        System.out.println("Majority Element: " + (result2 != null ? result2 : "null")); // Output: null
    }
}
