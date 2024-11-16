class Solution {
    public int minValidStrings(String[] words, String target) {
        Trie main = new Trie(' ');
        for (String s : words) main.add(s);
        long answer = helper(target, 0, main, new Long[target.length()]);
        if (answer >= Integer.MAX_VALUE) return -1;
        return (int)answer;
    }
    private long helper(String target, int index, Trie main, Long[] cache) {
        if (index >= target.length()) return 0;
        if (cache[index] != null) return cache[index];
        long answer = Integer.MAX_VALUE;
        Trie current = main;
        for (int i = index; i < target.length(); i++) {
            char c = target.charAt(i);
            if (current.children[c-'a'] == null) break;
            current = current.children[c-'a'];
            answer = Math.min(answer, helper(target, i+1, main, cache) + 1);
        }
        return cache[index] = answer;
    }
}

class Trie {
    char c;
    Trie[] children;
    Trie(char c) {
        this.c = c;
        this.children = new Trie[26];
    }
    void add(String s) {
        Trie current = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current.children[c-'a'] == null) {
                current.children[c-'a'] = new Trie(c);
            }
            current = current.children[c-'a'];
        }
    }
}