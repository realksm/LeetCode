class Solution {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] nums) {
        double[] A = new double[nums.length];
        for (int i = 0; i < nums.length; i++) A[i] = nums[i];
        return backtrack(A, A.length);
    }

    private boolean backtrack(double[] A, int n) {
        if (n == 1) return Math.abs(A[0] - 24.0) < EPS;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = A[i], b = A[j];

                // shrink by replacing j with last element
                A[j] = A[n - 1];

                // 1. addition (only once)
                A[i] = a + b;
                if (backtrack(A, n - 1)) return true;

                // 2. multiplication (only once)
                A[i] = a * b;
                if (backtrack(A, n - 1)) return true;

                // 3. both subtractions
                A[i] = a - b;
                if (backtrack(A, n - 1)) return true;

                A[i] = b - a;
                if (backtrack(A, n - 1)) return true;

                // 4. both divisions (guard zero)
                if (Math.abs(b) > EPS) {
                    A[i] = a / b;
                    if (backtrack(A, n - 1)) return true;
                }
                if (Math.abs(a) > EPS) {
                    A[i] = b / a;
                    if (backtrack(A, n - 1)) return true;
                }

                // restore
                A[i] = a;
                A[j] = b;
            }
        }
        return false;
    }
}