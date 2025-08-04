class Solution {
    private static final int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int daysBetweenDates(String date1, String date2) {
        return  Math.abs(days(date1) - days(date2));
    }

    public int days(String date) {
        int year = parse(date, 0, 4);
        int month = parse(date, 5, 7);
        int day = parse(date, 8, date.length());
        int res = 0;
        for(int i = 1971; i < year; i++) res += leap(i) ? 366 : 365;
        for(int i = 0; i < month; i++) res += days[i];
        if(month > 2 && leap(year)) res++;
        return res + day;
    }

    public boolean leap(int i) { return i % 4 == 0 && i % 100 != 0 || i % 400 == 0; }

    private int parse(String s, int start, int end) {
        int val = 0;
        for (int i = start; i < end; i++) {
            val = val * 10 + (s.charAt(i) - '0');
        }
        return val;
    }
}