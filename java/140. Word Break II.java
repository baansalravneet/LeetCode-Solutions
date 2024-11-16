class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie(false);
        for (String word: wordDict) {
            trie.add(word);
        }
        List<String> result = new ArrayList<>();
        find(result, s, 0, new StringBuilder(), trie);
        return result;
    }
    private void find(
        List<String> result,
        String s,
        int index,
        StringBuilder current,
        Trie trie
    ) {
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (trie.isWord(sb.toString())) {
                if (current.length() != 0) current.append(' ');
                current.append(sb.toString());
                find(result, s, i+1, current, trie);
                current.delete(current.length() - sb.length(), current.length());
                if (current.length() != 0) current.deleteCharAt(current.length()-1);
            }
        }
    }
    
}

class Trie {
    Trie[] children;
    boolean isWord;

    Trie(boolean isWord) {
        children = new Trie[26];
        this.isWord = isWord;
    }

    void add(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c-'a'] == null) {
                current.children[c-'a'] = new Trie(false);
            }
            current = current.children[c-'a'];
        }
        current.isWord = true;
    }

    boolean isWord(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c-'a'] == null) return false;
            current = current.children[c-'a'];
        }
        return current.isWord;
    }
}