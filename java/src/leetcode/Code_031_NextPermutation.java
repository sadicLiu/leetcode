public class Code_031_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;

        int idx = nums.length - 1;
        // 1. 找到nums[idx-1]<nums[idx]的位置
        while (idx >= 1) {
            if (nums[idx - 1] < nums[idx])
                break;
            idx--;
        }

        // 如果当前数已经是最大的了，直接将数组反转
        if (idx == 0) {
            reverseArray(nums, 0, nums.length - 1);
            return;
        }

        // 找到i到n-1位置最小的比i-1位置的元素大的元素
        int anchor = nums.length - 1;
        while (nums[anchor] <= nums[idx - 1]) {
            anchor--;
        }
        swap(nums, anchor, idx - 1);
        reverseArray(nums, idx, nums.length - 1);
    }

    public void reverseArray(int[] nums, int start, int end) {
        int l = start, r = end;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
