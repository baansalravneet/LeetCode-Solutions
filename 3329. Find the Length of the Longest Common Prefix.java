class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> p1 = new HashSet<>();
        Set<Integer> p2 = new HashSet<>();
        for (int i : arr1) {
            getPrefixes(i, p1);
        }
        for (int i : arr2) {
            getPrefixes(i, p2);
        }
        int answer = 0;
        for (int i : p1) {
            if (p2.contains(i)) {
                answer = Math.max(answer, getLength(i));
            }
        }
        return answer;
    }
    private void getPrefixes(int n, Set<Integer> prefixes) {
        while (n != 0) {
            prefixes.add(n);
            n /= 10;
        }
    }
    private int getLength(int i) {
        int count = 0;
        while (i != 0) {
            count++;
            i /= 10;
        }
        return count;
    }
}

