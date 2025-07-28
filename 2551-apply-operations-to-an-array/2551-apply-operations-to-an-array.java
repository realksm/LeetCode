class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
         // [1,4,0,2,0,0]
        int j = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                j = i;
                break;
            } 
        }
        if(j == -1) return nums;
        
        int k = j;
        for(int i = k + 1; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = (nums[i] + nums[j]) - (nums[i] = nums[j]);
                j++;
            }
        }
        return nums;
    }
}