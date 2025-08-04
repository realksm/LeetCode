class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, max = 0;

        for(int right = 0; right < fruits.length; right++) {
            count.merge(fruits[right], 1, Integer::sum);
            while(count.size() > 2) {
                count.merge(fruits[left], -1, Integer::sum);
                count.remove(fruits[left], 0);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}