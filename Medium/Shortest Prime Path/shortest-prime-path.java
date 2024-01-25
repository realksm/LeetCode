//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static List<String> primes;
    static boolean computed = false;

    public static void sieve() {
        int n = 9999;
        primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 1000; i <= n; i++) {
            if (isPrime[i]) {
                primes.add("" + i);
            }
        }
        
        computed = true;
    }

    public static int solve(int num1, int num2) {
        if(num1 == num2) return 0;
        if(!computed) sieve();
        
        int inf = (int) 1e9;
        
        Map<String, Integer> d = new HashMap<>();
        for(var i : primes) d.put(i, inf);
        
        String start = "" + num1;
        String end = "" + num2;
        
        d.put(start, 0);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            String curr = q.poll();
            
            for(int i = 0; i < 4; i++) {
                for(char j = (i == 0 ? '1' : '0'); j <= '9'; j++) {
                    if(j != curr.charAt(i)) {
                        char[] nextNum = curr.toCharArray();
                        nextNum[i] = j;
                        String next = new String(nextNum);
                        
                        if(d.containsKey(next) && d.get(next) > d.get(curr) + 1) {
                            d.put(next, d.get(curr) + 1);
                            q.add(next);
                            
                            if(next.equals(end)) return d.get(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends