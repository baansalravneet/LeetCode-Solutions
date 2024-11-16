class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        List<Integer> f = new ArrayList<>();
        for (int i : freq) if (i != 0) f.add(i);
        Collections.sort(f);
        return find(f, 0, f.size()-1, k);
    }
    private int find(List<Integer> f, int left, int right, int k) {
        if (left >= right) return 0;
        if (f.get(right) - f.get(left) <= k) return 0;
        return Math.min(
            f.get(left) + find(f, left+1, right, k),
            f.get(right) - f.get(left) - k + find(f, left, right-1, k)
        );
    }
}
