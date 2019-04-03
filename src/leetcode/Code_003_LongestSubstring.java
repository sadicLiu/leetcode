import java.util.HashMap;

public class Code_003_LongestSubstring {
    /*
     * 一个字符串中最长的没有重复的子串的长度
     * */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                // "abba"这种情况，遇到第二个b时l移动到2位置，遇到第二个a时l不能移动
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            r++;
            max = Math.max(max, r - l);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
