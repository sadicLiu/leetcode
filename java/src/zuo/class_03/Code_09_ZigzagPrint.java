package zuo.class_03;

public class Code_09_ZigzagPrint {
    public static void zigzagPrint(int[][] arr) {
        if (arr == null)
            return;
        int a = 0, b = 0, c = 0, d = 0;
        boolean fromUp = false;
        while (a < arr.length && d < arr[0].length) {
            printLine(arr, a, b, c, d, fromUp);
            a = b < arr[0].length - 1 ? a : a + 1;
            b = b < arr[0].length - 1 ? b + 1 : b;
            d = c < arr.length - 1 ? d : d + 1;
            c = c < arr.length - 1 ? c + 1 : c;
            fromUp = !fromUp;

        }
    }

    public static void printLine(int[][] arr, int a, int b, int c, int d, boolean fromUp) {
        if (fromUp) {
            for (int i = 0; i <= c - a; i++) {
                System.out.print(arr[a + i][b - i] + " ");
            }
        } else {
            for (int i = 0; i <= c - a; i++) {
                System.out.print(arr[c - i][d + i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        zigzagPrint(arr);
    }
}
