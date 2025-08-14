class Solution {
    public String largestGoodInteger(String num) {
        char maxChar = 0;

        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                if (c > maxChar) {
                    maxChar = c;
                    if (c == '9')
                        return "999";
                }
                i += 2;
            }
        }

        if (maxChar == 0) return "";
        return String.valueOf(maxChar).repeat(3);
    }
}