import java.util.Arrays;

public class Code_016_3SumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return -1;

        int closetSum = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int currentSum = nums[i] + nums[low] + nums[high];
                    int distance = Math.abs(currentSum - target);

                    if (currentSum == target)
                        return target;
                    else if (currentSum < target)
                        low++;
                    else
                        high--;
                    closetSum = distance < Math.abs(target - closetSum) ? currentSum : closetSum;
                }
            }
        }

        return closetSum;
    }

    public static void main(String[] args) {
        int res = new Code_016_3SumCloset().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(res);
    }
}
