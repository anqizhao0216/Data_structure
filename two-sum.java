class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
        if (nums == null || nums.length == 0) return res;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // assume there may have duplicates in nums
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
        
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            int firstValue = entry.getKey();
            int secondValue = target - firstValue;
            
            if (firstValue == secondValue && map.get(firstValue).size() > 1) {
                res[0] = map.get(firstValue).get(0);
                res[1] = map.get(firstValue).get(1);
                return res;
            } else if (map.containsKey(secondValue)) {
                res[0] = map.get(firstValue).get(0);
                res[1] = map.get(secondValue).get(0);
                return res;
            }
        }
        
        return res;
    }
}