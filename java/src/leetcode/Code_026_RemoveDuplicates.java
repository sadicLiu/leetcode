public class Code_026_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int left = 0, right = 1;
        int res = 1;
        int index = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                res++;
                nums[index++] = nums[right];
            }
            left++;
            right++;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
