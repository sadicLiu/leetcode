public class Code_014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        int end = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char cur_char = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != cur_char) {
                    return end == 0 ? "" : strs[0].substring(0, end);
                }
            }
            end++;
        }

        return end == 0 ? "" : strs[0].substring(0, end);
    }
}
