public class Solution {

    public int minimumSize(int[] nums, int s) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = 0, sum = 0, min = Integer.MAX_VALUE;

        while (r < nums.length) {
            sum += nums[r];
            r++;

            while (sum >= s) {
                min = Math.min(min, r - l);
                sum -= nums[l];
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}