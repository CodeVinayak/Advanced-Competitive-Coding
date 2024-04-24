import java.util.ArrayList;
public class LeadersInArray {
    // Function to find leaders in the array using brute-force approach
    public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            // Check if the current element is greater than any elements to its right
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break; // No need to check further if arr[j] > arr[i]
                }
            }
            // If the current element is a leader, add it to the result list
            if (isLeader) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // Array Initialization
        int n = 6;
        int[] arr = {16,17,4,3,5,2};
        // Find leaders in the array using the brute-force method
        ArrayList<Integer> leaders = printLeadersBruteForce(arr, n);
        // Print the leaders found
        System.out.print("Leaders in the array: ");
        for (int i = 0; i < leaders.size(); i++) {
            System.out.print(leaders.get(i) + " ");
        }
        System.out.println(); // Move to the next line after printing leaders
    }
}