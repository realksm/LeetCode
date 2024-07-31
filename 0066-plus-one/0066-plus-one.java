class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            digits[i] += carry;
            if(digits[i] / 10 != 0) {
                digits[i] %= 10;
                carry = 1; 
            } else {
                carry = 0;
            }
        }
        if(carry != 0) {
            int[] ans = new int[n + 1];
            ans[0] = carry;
            for(int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        }
        return digits;
    }
}