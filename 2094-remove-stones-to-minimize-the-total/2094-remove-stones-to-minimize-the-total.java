class Solution {
    public int minStoneSum(int[] piles, int k) {
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : piles) {
            total += i;
            pq.add(i);
        }

        while(k-- > 0) {
            total -= pq.peek();
            int max = (pq.poll() + 1) / 2;
            pq.add(max);
            total += max;
        }
        return (int) total;
    }
}