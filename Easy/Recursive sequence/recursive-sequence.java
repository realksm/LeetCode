//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        int mod = (int)1e9 + 7;
        
        long val = 1;
        for(int i = 2; i <= n; i++) {
            int s = (i * (i - 1))/2 + 1;
            int e = (i * (i + 1))/2;
            
            long term = 1;
            for(long j = s; j <= e; j++) {
                term *= j;
                term %= mod;
            }
            
            val += term;
            val %= mod;
        }
        
        return val;
    }
}