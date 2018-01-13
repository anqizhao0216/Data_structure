class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return ;
        
        int first = 0, second = 0;
        int n = nums.length;
        while (first < n && second < n) {
            if (nums[first] == 0 && nums[second] != 0) {
                swap(first, second, nums);
            }
            if (nums[first] != 0) first++;
            if (nums[second] == 0) second++;
            if (second < first) second = first;
        }
        
        return;
    }
    
    private void swap(int first, int second, int[] nums) {
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
        
        return;
    }
}