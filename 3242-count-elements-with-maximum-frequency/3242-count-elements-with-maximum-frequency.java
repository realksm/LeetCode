class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int max = 0, ans = 0;
        for(int x : nums) max = Math.max(max, ++count[x]);
        for(int x : nums) ans += (count[x] == max ?  1 : 0);
        return ans;
    }
}