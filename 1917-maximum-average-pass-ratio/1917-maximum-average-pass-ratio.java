class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0])
        );

        for (int[] c : classes) {
            double pass = c[0], total = c[1];
            pq.offer(new double[] { gain(pass, total), pass, total });
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            double pass = top[1] + 1, total = top[2] + 1;
            pq.offer(new double[] { gain(pass, total), pass, total });
        }

        double sum = 0;
        for (double[] c : pq) sum += c[1] / c[2];
        return sum / classes.length;
    }

    private double gain(double pass, double total) {
        return (pass + 1) / (total + 1) - pass / total;
    }
}
