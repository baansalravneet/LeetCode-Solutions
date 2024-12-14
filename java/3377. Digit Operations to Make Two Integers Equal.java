class Solution {
    private static final int LIMIT = (int)1e4 + 1;
    public int minOperations(int n, int m) {
        boolean[] primes = getPrimes();
        if (primes[n] || primes[m]) return -1;
        boolean[] visited = new boolean[LIMIT];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[] {n, n});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (current[0] == m) return current[1];
            if (visited[current[0]]) continue;
            visited[current[0]] = true;
            for (int next : getNext(current[0])) {
                if (visited[next]) continue;
                if (primes[next]) continue;
                pq.add(new int[] {next, current[1] + next});
            }
        }
        return -1;
    }
    private List<Integer> getNext(int n) {
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (!(c == '0' || (i == 0 && c == '1'))) {
                sb.setCharAt(i, (char)((int)c-1));
                answer.add(Integer.parseInt(sb.toString()));
                sb.setCharAt(i, c);
            }
            if (c != '9') {
                sb.setCharAt(i, (char)((int)c+1));
                answer.add(Integer.parseInt(sb.toString()));
                sb.setCharAt(i, c);
            }
        }
        return answer;
    }
    private boolean[] getPrimes() {
        boolean[] primes = new boolean[LIMIT];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < LIMIT; i++) {
            if (!primes[i]) continue;
            for (int j = i+i; j < LIMIT; j += i) {
                primes[j] = false;
            }
        }
        return primes;
    }
}
