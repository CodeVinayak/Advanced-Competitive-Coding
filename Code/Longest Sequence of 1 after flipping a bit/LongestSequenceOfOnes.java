public class LongestSequenceOfOnes {

    public static int longestSequence(int[] nums) {
        int maxSequence = 0;
        int currentSequence = 0;
        int prevSequence = 0;

        for (int num : nums) {
            if (num == 1) {
                currentSequence++;
            } else {
                prevSequence = currentSequence;
                currentSequence = 0;
            }

            maxSequence = Math.max(maxSequence, prevSequence + currentSequence + 1);
        }

        return maxSequence;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1, 1, 1};
        System.out.println("Longest sequence of 1s after flipping a bit: " + longestSequence(nums));
    }
}