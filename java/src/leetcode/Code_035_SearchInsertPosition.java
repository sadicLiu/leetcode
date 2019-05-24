public class Code_035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
