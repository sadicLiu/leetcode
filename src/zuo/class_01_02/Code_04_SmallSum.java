package zuo.class_01_02;

public class Code_04_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2 || left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int smallSum = 0;
        int p1 = left, p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] >= arr[p2]) {
                help[i++] = arr[p2++];
            } else {
                help[i++] = arr[p1++];
                smallSum += (right - p2 + 1) * help[i - 1];
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }

        return smallSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }


}
