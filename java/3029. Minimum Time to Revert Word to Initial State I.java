class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        Set<Integer> lengths = new HashSet<>();
        for (int length = 1; length < word.length(); length++) {
            String prefix = word.substring(0, length);
            if (word.indexOf(prefix, word.length()-length) != -1) {
                lengths.add(length);
            }
        }
        int count = 1;
        for (int i = k; i < word.length(); i += k) {
            if (lengths.contains(word.length()-i)) {
                return count;
            }
            count++;
        }
        return count;
    }
}

