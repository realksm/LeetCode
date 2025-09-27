class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;

        for(int[] p1 : points) {
            int x1 = p1[0], y1 = p1[1];
            for(int[] p2 : points) {
                int x2 = p2[0], y2 = p2[1];
                for(int[] p3 : points) {
                    int x3 = p3[0], y3 = p3[1];

                    int v1x = x2 - x1, v1y = y2 - y1;
                    int v2x = x3 - x1, v2y = y3 - y1;

                    double area = (v1x * v2y - v2x * v1y);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return 0.5 * maxArea;
    }
}