class Solution {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] nums) {
        double[] A = new double[nums.length];
        for (int i = 0; i < nums.length; i++) A[i] = nums[i];
        return dfs(A, A.length);
    }

    private boolean dfs(double[] A, int n) {
        if (n == 1) return Math.abs(A[0] - 24) < EPS;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = A[i], b = A[j];
                A[j] = A[n - 1];

                double[] ops = {a + b, a * b, a - b, b - a,
                                Math.abs(b) > EPS ? a / b : Double.NaN,
                                Math.abs(a) > EPS ? b / a : Double.NaN};

                for (double v : ops) {
                    if (!Double.isNaN(v)) {
                        A[i] = v;
                        if (dfs(A, n - 1)) return true;
                    }
                }

                A[i] = a; A[j] = b; // restore
            }
        }
        return false;
    }
}
