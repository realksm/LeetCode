class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = n - 1; i >= 2; --i) {
            int sum = nums[i - 1] + nums[i - 2];

            if(sum > nums[i]) {
                return nums[i] + sum;
            }
        }
        return 0;
    }
}