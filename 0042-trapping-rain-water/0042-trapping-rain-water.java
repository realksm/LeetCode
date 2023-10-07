class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        for(int k = 0; k < n; k++) {
            int max_l = 0;
            for(int l = 0; l < k; l++) max_l = Math.max(max_l, height[l]);
            int max_r = 0;
            for(int r = k + 1; r < n; r++) max_r = Math.max(max_r, height[r]);
            int water = Math.min(max_l, max_r) - height[k];
            ans += (water > 0) ? water : 0;
        }
        return ans;
    }
}