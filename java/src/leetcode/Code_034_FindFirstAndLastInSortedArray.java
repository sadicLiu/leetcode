public class Code_034_FindFirstAndLastInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1)
            return new int[]{-1, -1};

        int[] res = new int[]{-1, -1};
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                res[0] = (mid == 0 || nums[mid - 1] != target) ? mid : binarySearch(nums, 0, mid - 1, target, true);
                res[1] = (mid == nums.length - 1 || nums[mid + 1] != target) ? mid : binarySearch(nums, mid + 1, nums.length - 1, target, false);
                return res;
            }
        }
        return res;
    }

    public int binarySearch(int[] nums, int start, int end, int target, boolean isStart) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                if (isStart) {
                    if (mid == 0 || nums[mid - 1] != target)
                        return mid;
                    else
                        end = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target)
                        return mid;
                    else
                        start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] res = new int[2];
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        res = new Code_034_FindFirstAndLastInSortedArray().searchRange(nums, 8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
