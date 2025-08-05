class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int next = 1;
        int curr = isValid(s.charAt(n - 1)) ? 1 : 0;

        for (int i = n - 2; i >= 0; --i) {
            int temp = 0;
            if (isValid(s.charAt(i))) temp += curr;
            if (isValid(s.charAt(i), s.charAt(i + 1))) temp += next;
            next = curr;
            curr = temp;
        }

        return curr;
    }

    private boolean isValid(char c) {
        return c != '0';
    }

    private boolean isValid(char c1, char c2) {
        return c1 == '1' || c1 == '2' && c2 < '7';
    }
}