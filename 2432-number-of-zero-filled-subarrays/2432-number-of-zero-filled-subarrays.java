class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int last = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) ans += i - last;
            else last = i;
        }
        return ans;
    }
}