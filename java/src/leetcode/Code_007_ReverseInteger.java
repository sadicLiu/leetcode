public class Code_007_ReverseInteger {
    public static int reverse(int x) {
        if (x == 0)
            return 0;

        boolean isNegetive = x < 0 ? true : false;
        int absX = Math.abs(x);
        StringBuffer sb = new StringBuffer();
        while (absX > 0) {
            sb.append(String.valueOf(absX % 10));
            absX /= 10;
        }

        long result = Long.valueOf(sb.toString());  // 因为输入的是一个int，转换后的结果不会超出long
        long max = Integer.MAX_VALUE;
        if (isNegetive && result > max + 1 || !isNegetive && result > max)
            return 0;

        return (int) (result * (isNegetive ? -1 : 1));
    }

    public static void main(String[] args) {
           System.out.println(reverse(-123));
    }
}
