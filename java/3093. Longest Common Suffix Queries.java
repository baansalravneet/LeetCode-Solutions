class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie db = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            db.add(wordsContainer[i], i);
        }
        int[] answer = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            answer[i] = db.find(query);
        }
        return answer;
    }
}

class Trie {
    Trie[] children;
    int index;
    int length;
    Trie() {
        children = new Trie[26];
        index = Integer.MAX_VALUE;
        length = Integer.MAX_VALUE;
    }
    void add(String word, int index) {
        Trie current = this;
        if (current.length > word.length()) {
            current.length = word.length();
            current.index = index;
        }
        for (int i = word.length()-1; i >= 0; i--) {
            char c = word.charAt(i);
            if (current.children[c-'a'] == null) {
                current.children[c-'a'] = new Trie();
            }
            current = current.children[c-'a'];
            if (current.length > word.length()) {
                current.length = word.length();
                current.index = index;
            }
        }
    }
    int find(String q) {
        Trie current = this;
        for (int i = q.length()-1; i >= 0; i--) {
            char c = q.charAt(i);
            if (current.children[c-'a'] == null) break;
            current = current.children[c-'a'];
        }
        return current.index;
    }
}
