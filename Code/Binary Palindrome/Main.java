class Main {
    public static void main(String[] args) {
        int x = 9;
        String s = Integer.toBinaryString(x);
        // boolean ans = false;
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 = s1 + s.charAt(i);
        }

        if (s.equalsIgnoreCase(s1)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}


// The logic of the code is straightforward:

// It starts with a given integer x.
// It converts x to its binary representation using Integer.toBinaryString(x), which returns a string representing the binary value of x.
// It then iterates through the binary string from right to left (i starts from s.length() - 1 and decrements until i becomes 0).
// During each iteration, it appends the characters of the binary string s in reverse order to the string s1.
// After completing the loop, it checks if the original binary string s and the reversed binary string s1 are equal ignoring the case (equalsIgnoreCase).
// If they are equal, it prints "True" indicating that the binary representation of x is a palindrome. Otherwise, it prints "False"