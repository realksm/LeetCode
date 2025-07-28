class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieve(right + 1);

        List<Integer> primes = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isPrime[i]) primes.add(i);
        }

        if(primes.size() < 2) return new int[] {-1, -1};

        int minDiff = right;
        int p1 = 0;
        for(int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if(diff < minDiff) {
                minDiff = diff;
                p1 = i - 1;
            }
        }

        return new int[] {primes.get(p1), primes.get(p1 + 1)};
    }

    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i < n; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}