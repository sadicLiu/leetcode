package zuo.class_03;

public class Code_02_MaxGap {
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i] < min ? arr[i] : min;
            max = arr[i] > max ? arr[i] : max;
        }
        if (min == max) {
            return 0;
        }

        boolean[] hasNumber = new boolean[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            int index = getIndex(arr, i, min, max);
            if (!hasNumber[index]) {
                hasNumber[index] = true;
                mins[index] = arr[i];
                maxs[index] = arr[i];
            } else {
                mins[index] = arr[i] < mins[index] ? arr[i] : mins[index];
                maxs[index] = arr[i] > maxs[index] ? arr[i] : maxs[index];
            }
        }

        int maxGap = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < mins.length; i++) {
            if (!hasNumber[i])
                continue;
            int gap = mins[i] - lastMax;
            maxGap = gap > maxGap ? gap : maxGap;
            lastMax = maxs[i];
        }

        return maxGap;
    }

    public static int getIndex(int[] arr, int i, int min, int max) {
        return (int) (arr[i] - min) * arr.length / (max - min);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 22, 3, 4, 6, 7, 8, 99};
        System.out.println(maxGap(arr));

    }

}
