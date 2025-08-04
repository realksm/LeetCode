class Solution {
    private int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int daysBetweenDates(String date1, String date2) {
        return  Math.abs(days(date1) - days(date2));
    }

    public int days(String date) {
        int[] vals = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for(int i = 1971; i < vals[0]; i++) res += leap(i) ? 366 : 365;
        for(int i = 0; i < vals[1]; i++) res += days[i];
        if(vals[1] > 2 && leap(vals[0])) res++;
        return res + vals[2];
    }

    public boolean leap(int i) { return i % 4 == 0 && i % 100 != 0 || i % 400 == 0; }
}