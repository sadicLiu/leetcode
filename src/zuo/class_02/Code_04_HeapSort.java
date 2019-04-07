package zuo.class_02;

public class Code_04_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 建立大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        // 每次将一个数排好序, 然后重新调整成大根堆
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, heapSize - 1);
            heapify(arr, 0, --heapSize);
        }
    }

    // 逐个调整 arr 中的元素, 使其成为大根堆
    public static void heapInsert(int[] arr, int index) {
        int parent = (index - 1) / 2;
        while (parent >= 0 && arr[index] > arr[parent]) {
            swap(arr, index, parent);
            index = parent;
        }
    }

    // 重新将数组调整为大根堆
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1]
                    ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 3, 2, 0, 0};
        heapSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
