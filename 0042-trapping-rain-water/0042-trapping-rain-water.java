class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[][] max = new int[n][2]; // {max_l, max_r}
        max[0][0] = height[0];
        max[n - 1][1] = height[n - 1];

        for(int i = 1, j = n - 2; i < n; ++i, --j) {
            max[i][0] = Math.max(max[i - 1][0], height[i]);
            max[j][1] = Math.max(max[j + 1][1], height[j]);
        }

        int ans = 0;
        for(int k = 1; k < n - 1; k++) {
            int water = Math.min(max[k - 1][0], max[k + 1][1]) - height[k];
            ans += (water > 0) ? water : 0;
        }
        return ans;
    }
}