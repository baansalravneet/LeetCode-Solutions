class WordDictionary {

    Trie data;

    public WordDictionary() {
        data = new Trie(' ');
    }
    
    public void addWord(String word) {
        Trie current = data;
        for (char c : word.toCharArray()) {
            if (current.next[c-'a'] == null) {
                current.next[c-'a'] = new Trie(c);
            }
            current = current.next[c-'a'];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        Trie current = data;
        return helper(data, word, 0);
    }

    private boolean helper(Trie current, String word, int index) {
        if (current == null) {
            return false;
        }
        if (index == word.length()) {
            return current.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Trie next : current.next) {
                if (helper(next, word, index+1)) {
                    return true;
                }
            }
            return false;
        }
        return helper(current.next[c-'a'], word, index+1);
    }
}

class Trie {
    char c;
    Trie[] next;
    boolean isWord;
    
    Trie(char c) {
        this.c = c;
        next = new Trie[26];
        isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

