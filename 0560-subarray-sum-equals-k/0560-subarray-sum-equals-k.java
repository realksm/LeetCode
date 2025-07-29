class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int r = sum - k;
            count += map.getOrDefault(r, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}