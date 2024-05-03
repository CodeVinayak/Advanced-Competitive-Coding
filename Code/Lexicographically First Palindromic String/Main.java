class Main {
    static char MAX_CHAR = 26;
    static void countFreq(String str, int freq[], int len) {
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }
    }
    static boolean canMakePalindrome(int freq[], int len) {
        int count_odd = 0;
        for (int f : freq) {
            if (f % 2 != 0) {
                count_odd++;
            }
        }
        return len % 2 == 0 ? count_odd == 0 : count_odd == 1;
    }

    static String findOddAndRemoveItsFreq(int freq[]) {
        StringBuilder odd_str = new StringBuilder();
        for (int i = 0; i < MAX_CHAR; i++) {
            if (freq[i] % 2 != 0) {
                freq[i]--;
                odd_str.append((char) (i + 'a'));
                break;
            }
        }
        return odd_str.toString();
    }

    static String findPalindromicString(String str) {
        int len = str.length();
        int freq[] = new int[MAX_CHAR];
        countFreq(str, freq, len);

        if (!canMakePalindrome(freq, len)) {
            return "No Palindromic String";
        }

        String odd_str = findOddAndRemoveItsFreq(freq);
        StringBuilder front_str = new StringBuilder();
        StringBuilder rear_str = new StringBuilder();

        for (int i = 0; i < MAX_CHAR; i++) {
            StringBuilder temp = new StringBuilder();
            char ch = (char) (i + 'a');
            for (int j = 0; j < freq[i] / 2; j++) {
                temp.append(ch);
            }
            front_str.append(temp);
            rear_str.insert(0, temp);
        }
        return front_str.toString() + odd_str + rear_str.toString();
    }
    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(findPalindromicString(str));
    }
}
