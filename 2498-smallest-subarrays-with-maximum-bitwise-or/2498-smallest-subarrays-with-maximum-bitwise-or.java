class Solution {
    public int[] smallestSubarrays(int[] nums) {

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int currOr = nums[i];
            ans[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if((nums[j] | currOr) != nums[j]) {
                    nums[j] |= currOr;
                    ans[j] = i - j + 1;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}













        // int maxOr = 0;
        // for(int i : nums) maxOr |= i;

        // int i = 0, j = 0, currOr = 0;
        // while(i < nums.length && j < nums.length) {
        //     currOr |= nums[j];
        //     if(currOr == maxOr || j == nums.length - 1) {
        //         nums[i] = (j - i + 1); 
        //         i++;
        //         j = i;
        //         currOr = 0;
        //     } else {
        //         j++;
        //     }
        // }
        // return nums;