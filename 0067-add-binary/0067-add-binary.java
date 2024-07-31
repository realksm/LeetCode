class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0 || carry == 1) {
            if(i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            ans.append(carry % 2);
            carry /= 2;
        }
        return ans.reverse().toString();
    }
}