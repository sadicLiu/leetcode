package zuo.class_02;

public class Code_01_SplitArray {
    public static void splitArray(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int less = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
                swap(arr, less + 1, i);
                less++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 1, 2};
        splitArray(arr, 3);
        for (int i: arr)
            System.out.print(i + " ");
    }
}
