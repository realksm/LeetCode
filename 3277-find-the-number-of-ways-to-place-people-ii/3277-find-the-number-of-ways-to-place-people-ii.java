class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int count = 0;
        int n = points.length;

        for(int i = 0; i < n; i++) {
            int yi = points[i][1];
            int prevY = Integer.MIN_VALUE;
            for(int j = i + 1; j < n; j++) {
                int yj = points[j][1];
                if(yj <= yi && yj > prevY) {
                    count++;
                    prevY = yj;
                    if(yj == yi) break;
                }
            }
        }
        return count;
    }
}