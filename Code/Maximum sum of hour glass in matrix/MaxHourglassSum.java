import java.util.Scanner;

public class MaxHourglassSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int R = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int C = sc.nextInt();

        int[][] mat = new int[R][C];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int res = findMaxSum(mat, R, C);
        System.out.println("Maximum sum of hourglass = " + res);
    }

    public static int findMaxSum(int[][] mat, int R, int C) {
        if (R < 3 || C < 3) {
            return -1; // Cannot form an hourglass
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= R - 3; i++) {
            for (int j = 0; j <= C - 3; j++) {
                int sum = mat[i][j] + mat[i][j + 1] + mat[i][j + 2]
                        + mat[i + 1][j + 1]
                        + mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
