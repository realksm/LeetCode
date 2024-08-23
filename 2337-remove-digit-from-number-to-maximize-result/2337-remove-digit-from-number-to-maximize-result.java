class Solution {
    public String removeDigit(String number, char digit) {
        String maxNumber = "";
        for(int i = 0; i < number.length(); i++) {
            if(digit == number.charAt(i)) {
                String newNumber = number.substring(0, i) + number.substring(i + 1);
                if(newNumber.compareTo(maxNumber) > 0) {
                    maxNumber = newNumber;
                }
            }
        }
        return maxNumber;
    }
}