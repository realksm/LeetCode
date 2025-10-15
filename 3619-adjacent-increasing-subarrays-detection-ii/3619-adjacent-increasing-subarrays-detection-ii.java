class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int pre = 0, suff = 1, ans = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) suff++;
            else { pre = suff; suff = 1; }
            ans = Math.max(ans, Math.max(suff / 2, Math.min(pre, suff)));
        }
        return ans;
    }
}