package zuo.class_02;

public class Code_02_NetherlandsFlag {
    public static void netherlandsFlag(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int left = -1, right = arr.length;
        int cur = 0;
        while (cur < right) {
            if (arr[cur] < num) {
                swap(arr, cur, ++left);
                cur++;
            } else if (arr[cur] == num) {
                cur++;
            } else {
                swap(arr, cur, right - 1);
                right--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 3, 3, 4, 5, 1, 0};
        netherlandsFlag(arr, 3);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
