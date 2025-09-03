class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        int count = 0;
        int n = points.length;

        for(int i = 0; i < n - 1; i++) {
            int yi = points[i][1];
            int prevY = Integer.MAX_VALUE;
            for(int j = i + 1; j < n; j++) {
                int yj = points[j][1];
                if(yj >= yi && prevY > yj) {
                    count++;
                    prevY = yj;
                    if(yj == yi) break;
                }
            }
        }
        return count;
    }
}