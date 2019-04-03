public class Code_011_ContainersWithMostWater {

    /*
    * 给定一个数组，表示木板的高度
    * 求这个数组中两块木板组成的容器最多能装多少水
    * */

    /*
    * 思路：
    * 1.最左和最右两块木板拥有最大的宽度，所以可以尝试从这两块木板开始
    * 2.位于这两块木板中间的木板，如果要想比这两块木板装更多水，由于宽度小了，只能增加木板的高度
    *   因此，丢掉上一步的木板中高度较小的那块，继续尝试
    * */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        int water = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            water = Math.max(water, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return water;
    }
}
