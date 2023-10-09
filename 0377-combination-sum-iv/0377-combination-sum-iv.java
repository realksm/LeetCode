class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return f(nums, target, dp);
    }
    public int f(int[] nums, int target, Integer[] dp) {
        if(target < 0) return 0;
        if(dp[target] != null) return dp[target];
        if(target == 0) return 1;

        int ans = 0;
        for(int i = 0; i< nums.length; i++) {
            ans += f(nums, target - nums[i], dp);
        }

        return dp[target] = ans;
    }
}