public class Code_027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1)
            return 0;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != index) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return index;
    }
}
