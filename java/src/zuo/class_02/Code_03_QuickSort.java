package zuo.class_02;

public class Code_03_QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2 || left >= right) {
            return;
        }

        swap(arr, right, left + (int) (Math.random() * (right - left + 1)));
        int[] p = partition(arr, left, right);
        quickSort(arr, left, p[0] - 1);
        quickSort(arr, p[1] + 1, right);
    }

    public static int[] partition(int[] arr, int left, int right) {
        int num = arr[right];
        int[] p = new int[]{left - 1, right + 1};
        int cur = left;
        while (cur < p[1]) {
            if (arr[cur] < num) {
                swap(arr, ++p[0], cur++);
            } else if (arr[cur] == num) {
                cur++;
            } else {
                swap(arr, cur, --p[1]);
            }
        }

        return p;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 3, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
