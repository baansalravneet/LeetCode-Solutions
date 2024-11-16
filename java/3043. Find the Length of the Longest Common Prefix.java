class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();
        for (int i : arr1) t.add(String.valueOf(i));
        int answer = 0;
        for (int i : arr2)  answer = Math.max(answer, t.get(String.valueOf(i)));
        return answer;
    }
}

class Trie {
    char c;
    Trie[] children;
    Trie() {
        children = new Trie[10];
    }
    void add(String s) {
        Trie current = this;
        for (char c : s.toCharArray()) {
            if (current.children[c-'0'] == null) {
                current.children[c-'0'] = new Trie();
            }
            current = current.children[c-'0'];
        }
    }
    int get(String s) {
        int length = 0;
        Trie current = this;
        for (char c : s.toCharArray()) {
            if (current.children[c-'0'] == null) return length;
            current = current.children[c-'0'];
            length++;
        }
        return length;
    }
}