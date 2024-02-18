class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        Trie root = new Trie();
        long count = 0;
        for (String word : words) {
            count += find(root, word);
        }
        return count;
    }
    private long find(Trie curr, String s) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) * 128 + s.charAt(s.length()-1-i);
            curr = curr.children.computeIfAbsent(key, k -> new Trie());
            count += curr.count;
        }
        curr.count++;
        return count;
    }
}

class Trie {
    Map<Integer, Trie> children = new HashMap<>();
    long count = 0;
}
