public class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] arr = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        return dfs(arr, nums.length);
    }

    private boolean dfs(double[] nums, int n) {
        if (n == 1) {
            return Math.abs(nums[0] - 24.0) < 1e-3;
        }

        // Try every pair of numbers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums[i];
                double b = nums[j];

                // store old nums for backtracking
                double[] next = new double[n - 1];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next[idx++] = nums[k];
                    }
                }

                // Try all possible results
                for (double val : generate(a, b)) {
                    next[idx] = val;
                    if (dfs(next, n - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] generate(double a, double b) {
        double eps = 1e-6;
        return new double[]{
            a + b,
            a - b,
            b - a,
            a * b,
            Math.abs(b) < eps ? Double.NaN : a / b,
            Math.abs(a) < eps ? Double.NaN : b / a
        };
    }
}
