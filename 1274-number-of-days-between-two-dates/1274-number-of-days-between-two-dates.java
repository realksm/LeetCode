class Solution {
    private int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int daysBetweenDates(String date1, String date2) {
        return  Math.abs(days(date1) - days(date2));
    }

    public int days(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        int res = 0;
        for(int i = 1971; i < year; i++) res += leap(i) ? 366 : 365;
        for(int i = 0; i < month; i++) res += days[i];
        if(month > 2 && leap(year)) res++;
        return res + day;
    }

    public boolean leap(int i) { return i % 4 == 0 && i % 100 != 0 || i % 400 == 0; }
}