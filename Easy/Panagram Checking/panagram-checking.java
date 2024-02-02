//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        boolean[] seen = new boolean[26];
        
        for(char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                seen[c - 'a'] = true;
            }
            if(c >= 'A' && c <= 'Z') {
                seen[c - 'A'] = true;
            }
        }
        
        for(boolean c : seen) if(!c) return false;
        
        return true;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends