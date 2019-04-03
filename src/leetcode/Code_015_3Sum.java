import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_015_3Sum {

    /*
     * 找到一个数组中所有和为0的三元组
     * */

    /*
     * 先把这个数组排序，然后依次找当前位置后面是否有两个元素和为0-nums[i]
     * 不要往前找，前面位置已经找过了，再往前就重了
     * */

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { // 重复元素不要重复计算
                int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
                int count = 0;

                while (low < high) {

                    if (nums[low] + nums[high] == sum) {
                        if (count == 0 || nums[low] != nums[low - 1]) {
                            count++;
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[low]);
                            temp.add(nums[high]);

                            res.add(temp);
                        }

                        low++;
                        high--;
                    }

                    while (nums[low] + nums[high] > sum && low < high) high--;
                    while (nums[low] + nums[high] < sum && low < high) low++;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Code_015_3Sum().threeSum(new int[]{-4, -1, -1, 0, 1, 2});
    }
}
