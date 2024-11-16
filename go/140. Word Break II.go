func wordBreak(s string, wordDict []string) []string {
	trie := &Trie{
		children: make([]*Trie, 26),
		isWord:   false,
	}
	for _, word := range wordDict {
		trie.add(word)
	}
	result := []string{}
	find(&result, s, 0, []string{}, trie)
	return result
}

func find(result *[]string, s string, index int, current []string, trie *Trie) {
	if index == len(s) {
		answer := strings.Join(current, " ")
		*result = append(*result, answer)
		return
	}
	for i := index; i < len(s); i++ {
		sub := s[index : i+1]
		if trie.search(sub) {
			current = append(current, sub)
			find(result, s, i+1, current, trie)
			current = current[:len(current)-1]
		}
	}
}

type Trie struct {
	children []*Trie
	isWord   bool
}

func (t *Trie) add(word string) {
	current := t
	for _, c := range word {
		if current.children[c-'a'] == nil {
			current.children[c-'a'] = &Trie{
				children: make([]*Trie, 26),
				isWord:   false,
			}
		}
		current = current.children[c-'a']
	}
	current.isWord = true
}

func (t *Trie) search(word string) bool {
	current := t
	for _, c := range word {
		if current.children[c-'a'] == nil {
			return false
		}
		current = current.children[c-'a']
	}
	return current.isWord
}
