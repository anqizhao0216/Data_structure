





// 实际的代码写起来可能比想象中的要简单许多。有了思路之后先写出来，然后再对代码进行优化。
// 思考的过程可以很直接。其实要学习的往往是思考方式以及优化的角度。
// 这道题之所以要用two pointer 解决是因为两次for 循环遍历重复计算了很多次，导致时间复杂度很高。
// 双指针就是通过 “记住” 某个值 从而减少重复的劳动，加两根指针，少一层循环


public class Solution {
    /*
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int j = 0, sum = 0, min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                min = Math.min(min, j - i);
            }
            sum -= nums[i];
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}