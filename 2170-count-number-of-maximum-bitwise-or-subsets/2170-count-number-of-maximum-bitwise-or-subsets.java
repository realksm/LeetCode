class Solution {
    int[] nums;
    int count;
    int maxOr;
    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        for(int i : nums) maxOr |= i;
        this.nums = nums;
        dfs(0, 0);
        return count;
    }

    public void dfs(int i, int currentOr) {
        if(i == nums.length) {
            if(currentOr == maxOr) count++;
            return;
        }
        dfs(i + 1, currentOr);
        dfs(i + 1, currentOr | nums[i]);
    }
}