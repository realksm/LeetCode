class Solution {
    public String largestGoodInteger(String num) {
        char[] ch = num.toCharArray();
        char maxChar = 0;

        for (int i = 0; i <= ch.length - 3; i++) {
            if (ch[i] == ch[i + 1] && ch[i] == ch[i + 2]) {
                if (ch[i] > maxChar) {
                    maxChar = ch[i];
                }
                i += 2;
            }
        }
        return maxChar == 0 ? "" : String.valueOf(maxChar).repeat(3);
    }
}