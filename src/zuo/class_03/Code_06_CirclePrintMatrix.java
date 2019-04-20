package zuo.class_03;

public class Code_06_CirclePrintMatrix {
    public static void circlePrint(int[][] matrix) {
        if (matrix == null)
            return;
        int a = 0, b = 0, c = matrix.length - 1, d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--);
        }
    }

    public static void printEdge(int[][] matrix, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.print(matrix[a][i] + " ");
            }
        }

        if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.print(matrix[i][b] + " ");
            }
        }

        for (int i = b; i < d; i++) {
            System.out.print(matrix[a][i] + " ");
        }

        for (int i = a; i < c; i++) {
            System.out.print(matrix[i][d] + " ");
        }

        for (int i = d; i > b; i--) {
            System.out.print(matrix[c][i] + " ");
        }

        for (int i = c; i > a; i--) {
            System.out.print(matrix[i][b] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        circlePrint(matrix);
    }
}
