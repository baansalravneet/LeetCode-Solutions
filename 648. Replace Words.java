class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie db = new Trie();
        for (String word : dictionary) db.add(word);
        List<String> answer = new ArrayList<>();
        for (String word : sentence.split(" ")) {
            answer.add(db.find(word));
        }
        return String.join(" ", answer);
    }
}

class Trie {
    Trie[] children;
    boolean isWord;

    Trie() {
        this.children = new Trie[26];
    }
    
    void add(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (current.children[c] == null) {
                current.children[c] = new Trie();
            }
            current = current.children[c];
        }
        current.isWord = true;
    }

    String find(String word) {
        StringBuilder sb = new StringBuilder();
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            if (current.isWord) return sb.toString();
            if (current.children[c] == null) return word;
            sb.append(Character.toString('a' + c));
            current = current.children[c];
        }
        return sb.toString();
    }
}
