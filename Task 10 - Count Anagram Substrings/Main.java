import java.util.*;

public class Main {

    public static int countAnagrams(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        // If pattern is longer than text
        if (m > n) {
            return 0;
        }

        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];

        // Count frequency of characters in pattern
        for (char c : pattern.toCharArray()) {
            patternFreq[c - 'a']++;
        }

        // Create frequency for the first window
        for (int i = 0; i < m; i++) {
            windowFreq[text.charAt(i) - 'a']++;
        }

        int count = 0;

        // Check first window
        if (Arrays.equals(patternFreq, windowFreq)) {
            count++;
        }

        // Slide the window
        for (int i = m; i < n; i++) {

            // Add new character
            windowFreq[text.charAt(i) - 'a']++;

            // Remove old character
            windowFreq[text.charAt(i - m) - 'a']--;

            // Check if current window is an anagram
            if (Arrays.equals(patternFreq, windowFreq)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();

        int result = countAnagrams(text, pattern);

        System.out.println(result);

        sc.close();
    }
}