import java.util.HashMap;

public class Code_001_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int[] res = twoSum(arr, 18);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
