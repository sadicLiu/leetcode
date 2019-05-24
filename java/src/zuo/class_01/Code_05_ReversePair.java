package zuo.class_01;

public class Code_05_ReversePair {
    public static void reversePair(int[] arr) {
        int[][] pairs = new int[0][0];
        if (arr == null || arr.length < 2) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                for (int j = p1; j <= mid; j++) {
                    System.out.println("<" + arr[j] + ", " + arr[p2] + ">");
                }
                help[i++] = arr[p2++];
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
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 2};
        reversePair(arr);
    }
}
