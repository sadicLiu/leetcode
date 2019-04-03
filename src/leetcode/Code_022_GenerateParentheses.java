import java.util.*;

public class Code_022_GenerateParentheses {
    /*
     * 非递归方法
     * */
    public List<String> generateParenthesis_unrec(int n) {
        if (n == 0)
            return new ArrayList<String>();

        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        map.put(1, new ArrayList<String>(Arrays.asList("()")));

        HashSet<String> set = null;
        for (int i = 2; i <= n; i++) {
            set = new HashSet<>();
            set.addAll(addBracket(map.get(i - 1)));

            for (int j = 1; j < i; j++) {
                List<String> concatRes = concatenate(map.get(j), map.get(i - j));
                set.addAll(concatRes);
            }

            map.put(i, new ArrayList<String>(Arrays.asList(set.toArray(new String[0]))));
        }


        return map.get(n);
    }

    public List<String> addBracket(List<String> src) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : src) {
            String tmp = "(" + s + ")";
            res.add(tmp);
        }

        return res;
    }

    public List<String> concatenate(List<String> s1, List<String> s2) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();

        for (String str1 : s1) {
            for (String str2 : s2) {
                set.add(str1 + str2);
            }
        }

        res.addAll(Arrays.asList(set.toArray(new String[0])));
        return res;
    }

    /*
     * 递归方法
     * */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        // 在一个字符串中我们可以添加n个(和n个),如果(的个数小于n,此时可以选择添加（
        // 如果此时）的个数小于（,此时也可以选择添加）
        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        List<String> res = new Code_022_GenerateParentheses().generateParenthesis(3);
        for (String s : res)
            System.out.println(s);
    }


}
