public class Code_033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int res = -1;
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;

        while (mid != 0 &&
                mid != nums.length - 1 &&
                !(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) &&
                !(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) &&
                low <= high) {
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid - 1;
            mid = (low + high) / 2;
        }

        if (nums[mid] == target)
            return mid;
        res = binarySearch(nums, target, 0, mid - 1);
        if (res != -1)
            return res;
        return binarySearch(nums, target, mid + 1, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        System.out.println(new Code_033_SearchInRotatedSortedArray().search(a, 0));
    }

}
