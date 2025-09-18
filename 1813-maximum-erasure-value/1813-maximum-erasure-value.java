class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[10001];
        int ans = 0, score = 0;

        for (int l = 0, r = 0; r < n; ++r) {
            while (freq[nums[r]] > 0) {
                freq[nums[l]]--;
                score -= nums[l++];
            }
            freq[nums[r]]++;
            score += nums[r];
            ans = Math.max(ans, score);
        }

        return ans;
    }
}