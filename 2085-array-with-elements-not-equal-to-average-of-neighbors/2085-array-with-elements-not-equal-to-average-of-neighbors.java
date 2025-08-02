class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Arrays.sort(nums);
        // for(int i = 1; i < nums.length; i += 2) {
        //     nums[i] = nums[i] + nums[i - 1] - (nums[i - 1] = nums[i]);
        // }
        // return nums;

        int temp;
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] == (nums[i - 1] + nums[i + 1]) / 2) {
                nums[i] = nums[i] + nums[i + 1] - (nums[i + 1] = nums[i]);
                if(i >= 2) i -= 2;
            }
        }
        
        return nums;
    }
}