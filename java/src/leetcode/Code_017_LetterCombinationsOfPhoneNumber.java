import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code_017_LetterCombinationsOfPhoneNumber {

    HashMap<Integer, char[]> map;

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0)
            return res;

        map = new HashMap<>();
        char ch = 'a';
        for (int i = 2; i <= 9; i++) {
            int end = (i == 7 || i == 9) ? 3 : 2;
            char[] temp = new char[end + 1];
            for (int j = 0; j <= end; j++) {
                temp[j] = ch++;
            }
            map.put(i, temp);
        }

        process(digits, 0, "", res);
        return res;
    }

    public void process(String digits, int index, String cur, List<String> res) {
        if (index == digits.length()) {
            res.add(cur);
            return;
        }

        int key = Integer.valueOf(String.valueOf(digits.charAt(index)));
        char[] ch = map.get(key);
        for (int i = 0; i < ch.length; i++) {
            process(digits, index + 1, cur + ch[i], res);
        }
    }

    public static void main(String[] args) {
        new Code_017_LetterCombinationsOfPhoneNumber().letterCombinations("23");
    }
}
