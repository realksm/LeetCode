class Solution {
    public int removeElement(int[] nums, int val) {
        int i = -1, j = 0;
        while(i++ < nums.length - 1) {
            if(nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}