class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0 , sum = 0, left = 0;
        for(int right = 0; right < fruits.length; right++) {
            sum += fruits[right][1];
            while(left <= right && !canReach(fruits[left][0], fruits[right][0], startPos, k)) {
                sum -= fruits[left][1];
                left++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public boolean canReach(int left, int right, int start, int k) {
        if(right <= start) return start - left <= k;
        if(left >= start) return right - start <= k;
        int leftDist = start - left, rightDist = right - start;
        return Math.min(2 * leftDist + rightDist, 2 * rightDist + leftDist) <= k;
    } 
}