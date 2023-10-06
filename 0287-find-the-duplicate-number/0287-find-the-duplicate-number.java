class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] isPresent = new boolean[nums.length];
        for(int j = 0;j < nums.length;j++){
            if(isPresent[nums[j]]){
                return nums[j];
            }
            isPresent[nums[j]] = true;
        }
        return -1;
    }
}