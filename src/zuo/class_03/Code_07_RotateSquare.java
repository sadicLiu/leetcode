package zuo.class_03;

public class Code_07_RotateSquare {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length)
            return;
        int a = 0, b = 0, c = matrix.length - 1, d = c;
        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }

    public static void rotateEdge(int[][] matrix, int a, int b, int c, int d) {
        int times = d - b;
        for (int i = 0; i < times; i++) {
            int tmp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }
}
