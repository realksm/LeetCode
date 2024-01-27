//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            int h = a[0],m = a[1];
            Solution obj = new Solution();
            int res = obj.maxLevel(h,m);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    /*
    path 3 -> H -= 20, M += 5;
    path 2 -> H -= 5, M -= 10;
    path 1 -> H += 3, M += 2;
    */
    public static int maxLevel(int h,int m) {
        int level = 0;
        
        boolean onOne = true;
        
        while(h > 0 && m > 0) {
            if(onOne) {
                h += 3;
                m += 2;
                level++;
                onOne = false;
            } else {
                onOne = true;
                level++;
                if(h > 5 && m > 10) {
                    h -= 5;
                    m -= 10;
                } else {
                    h -= 20;
                    m += 5;
                }
            }
        }
        return level - 1;
    }
}
        
