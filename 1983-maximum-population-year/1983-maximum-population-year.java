class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[2051];
        for(int[] log : logs) {
            population[log[0]]++;
            population[log[1]]--;
        }

        int sum = 0, max = 0, year = 0;
        for(int i = 1950; i <= 2050; i++) {
            sum += population[i];
            if(sum > max) {
                max = sum;
                year = i;
            }
        }
        return year;
    }
}