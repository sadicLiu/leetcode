import java.util.*;

public class Code_039_CombinationSum {
    HashSet<ArrayList<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new HashSet<>();
        List<Integer> temp = new ArrayList<Integer>();
        process(candidates, target, temp, 0, 0);

        List<List<Integer>> data = new ArrayList<>();
        Iterator<ArrayList<Integer>> iter = res.iterator();
        while (iter.hasNext())
            data.add(iter.next());
        return data;
    }

    public void process(int[] arr, int target, List<Integer> nums, int currentSum, int index) {
        if (index == arr.length || currentSum > target)
            return;

        process(arr, target, nums, currentSum, index + 1);  // ignore current number

        nums.add(arr[index]);
        currentSum += arr[index];
        if (currentSum == target) {
            res.add(new ArrayList<Integer>(nums));
            nums.remove(nums.size() - 1);
            return;
        }
        process(arr, target, nums, currentSum, index); // add current number but don't move
        process(arr, target, nums, currentSum, index + 1);
        nums.remove(nums.size() - 1);
        currentSum -= arr[index];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,6,7};
        new Code_039_CombinationSum().combinationSum(arr, 7);
    }
}
