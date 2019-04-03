public class Code_004_LongestPalindromicSubstring {

    int start;
    int maxLen;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        for (int i = 0; i < s.length(); i++) {
            explore(s, i, i);   // odd substring length
            explore(s, i, i + 1);   // even substring length
        }

        return s.substring(start, start + maxLen);
    }

    public void explore(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }

        if (high - low - 1 > maxLen) {
            maxLen = high - low - 1;
            start = low + 1;
        }
    }

}
