func replaceWords(dictionary []string, sentence string) string {
    db := newTrie()
    for _, word := range dictionary {
        db.add(word)
    }
    answer := []string{}
    for _, word := range strings.Split(sentence, " ") {
        answer = append(answer, db.find(word))
    }
    return strings.Join(answer, " ")
}

type Trie struct {
    children []*Trie
    isWord bool
}

func newTrie() *Trie {
    return &Trie {
        children: make([]*Trie, 26, 26),
        isWord: false,
    }
}

func (t *Trie) add(word string) {
    for _, c := range(word) {
        if t.children[c-'a'] == nil {
            t.children[c-'a'] = newTrie()
        }
        t = t.children[c-'a']
    }
    t.isWord = true
}

func (t *Trie) find(word string) string {
    answer := ""
    for _, c := range word {
        if t.isWord {
            return answer
        }
        if t.children[c-'a'] == nil {
            return word
        }
        answer += string(c)
        t = t.children[c-'a']
    }
    return answer
}
