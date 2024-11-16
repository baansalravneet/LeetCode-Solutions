class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int maxNum = -1;
        for (int i : nums) {
            maxNum = Math.max(maxNum, i);
        }
        int[] count = new int[maxNum+1];
        for (int i : nums) {
            count[i]++;
        }
        List<Integer> primes = getPrimes(maxNum);
        UnionFind dsu = new UnionFind(maxNum+1);
        for (int i = 0; i <= maxNum; i++) {
            if (count[i] == 0) continue;
            if (i == 1) return false;
            for (int prime : primes) {
                if (prime > i) break;
                if (i % prime == 0) {
                    dsu.union(i, prime);
                }
            }
        }
        int cParent = dsu.find(nums[0]);
        for (int i : nums) {
            if (dsu.find(i) != cParent) return false;
        }
        return true;
    }
    private List<Integer> getPrimes(int max) {
        boolean[] sieve = new boolean[max+1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i <= Math.sqrt(sieve.length); i++) {
            if (!sieve[i]) continue;
            int j = i+i;
            while (j < sieve.length) {
                sieve[j] = false;
                j += i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) result.add(i);
        }
        return result;
    }
}

class UnionFind {
    int[] parent;
    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    int find(int n) {
        return parent[n] == n ? n : (parent[n] = find(parent[n]));
    }
    void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA < pB) parent[pB] = pA;
        else parent[pA] = pB;
    }
}

