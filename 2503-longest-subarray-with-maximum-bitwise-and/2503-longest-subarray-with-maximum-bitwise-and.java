class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i : nums) max = Math.max(max, i);
        int count = 1;
        for(int i = 0; i < nums.length; i++) {
            int curr = 0;
            while(i <  nums.length && nums[i] == max) {
                curr++;
                i++;
            }
            count = Math.max(curr, count);
        }
        return count;
    }
}