import java.util.Scanner;

public class Booth {
    public static Scanner s = new Scanner(System.in);

    public int multiply(int n1, int n2) {
        int[] m = binary(n1);
        int[] m1 = binary(-n1);
        int[] r = binary(n2);
        int[] A = new int[9];
        int[] S = new int[9];
        int[] P = new int[9];
        
        for (int i = 0; i < 4; i++) {
            A[i] = m[i];
            S[i] = m1[i];
            P[i + 4] = r[i];
        }

        display(A, 'A');
        display(S, 'S');
        display(P, 'P');

        System.out.println();

        for (int i = 0; i < 4; i++) {
            if (P[7] == 0 && P[8] == 0) {
                // do nothing
            } else if (P[7] == 1 && P[8] == 0) {
                add(P, S);
            } else if (P[7] == 0 && P[8] == 1) {
                add(P, A);
            } else if (P[7] == 1 && P[8] == 1) {
                // do nothing
            }
            rightShift(P);
            display(P, 'P');
        }
        return getDecimal(P);
    }

    public int[] binary(int n) {
        int[] bin = new int[4];
        int ctr = 3;
        int num = n;
        // handle negative number
        if (n < 0) {
            num = Math.abs(n);
            num = ~num;
            num += 1;
        }
        while (num != 0 && ctr >= 0) {
            bin[ctr--] = num % 2;
            num /= 2;
        }
        return bin;
    }

    public void display(int[] arr, char ch) {
        System.out.print("\n" + ch + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public void add(int[] P, int[] AorS) {
        int carry = 0;
        for (int i = 7; i >= 0; i--) {
            int temp = P[i] + AorS[i] + carry;
            P[i] = temp % 2;
            carry = temp / 2;
        }
    }

    public void rightShift(int[] P) {
        for (int i = 8; i >= 1; i--) {
            P[i] = P[i - 1];
        }
    }

    public int getDecimal(int[] P) {
        int num = 0;
        int neg = 0;
        if (P[0] == 1) {
            neg = 1;
            for (int i = 0; i < 8; i++) {
                if (P[i] == 0) {
                    P[i] = 1;
                } else {
                    P[i] = 0;
                }
            }
            add(P, new int[] {0, 0, 0, 0, 0, 0, 0, 1});
        }
        for (int i = 7; i >= 0; i--) {
            num += Math.pow(2, 7 - i) * P[i];
        }
        if (neg == 1) {
            num = -num;
        }
        return num;
    }

    public static void main(String[] args) {
        Booth b = new Booth();
        System.out.println("\nEnter two integer numbers\n");
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int result = b.multiply(n1, n2);
        System.out.println("\n\nResult : "+ result);
    }
}
