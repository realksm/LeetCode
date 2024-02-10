//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long numberOfPath(int n, int k, int [][]arr) {
        Long[][][] dp = new Long[n][n][k + 1];
        return func(n - 1, n - 1, k, arr, dp);
    }
    
    long func(int i, int j, int k, int[][] arr, Long[][][] dp) {
        if(i < 0 || j < 0 || k < 0) {
            return 0;
        }
        if(i == 0 && j == 0) {
            return (k == arr[i][j]) ? 1L : 0L;
        }
        
        if(dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        
        dp[i][j][k] = func(i - 1, j, k - arr[i][j], arr, dp) + 
                        func(i, j - 1, k - arr[i][j], arr, dp);
        
        return dp[i][j][k];
    }
}