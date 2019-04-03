package class_01_02_repetition;

public class Code_03_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSortCore(arr, 0, arr.length - 1);
    }

    public static void mergeSortCore(int[] arr, int l, int r) {
        if (r <= l) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSortCore(arr, l, mid);
        mergeSortCore(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 0};
        mergeSort(a);
        for (int i : a)
            System.out.println(i);

        // int l = 0, r = 3;
        // int mid = l + (r - l) >> 1;
        // System.out.println(mid);
    }
}
