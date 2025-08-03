class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) prefix[i] = prefix[i - 1] + nums[i];
        int count = 0;
        for(int i : prefix) if(i == 0) count++;
        return count;
    }
}