func stringIndices(wordsContainer []string, wordsQuery []string) []int {
	db := &Trie{Children: make(map[rune]*Trie), Index: math.MaxInt32, Length: math.MaxInt32}
	for i, word := range wordsContainer {
		db.Add(word, i)
	}
	answer := []int{}
	for _, word := range wordsQuery {
		answer = append(answer, db.Find(word))
	}
	return answer
}

type Trie struct {
	Children map[rune]*Trie
	Index    int
	Length   int
}

func (t *Trie) Add(word string, index int) {
	current := t
	if current.Length > len(word) {
		current.Length = len(word)
		current.Index = index
	}
	for i, _ := range word {
		c := rune(word[len(word)-1-i])
		if _, ok := current.Children[c]; !ok {
			current.Children[c] = &Trie{Children: make(map[rune]*Trie), Index: math.MaxInt32, Length: math.MaxInt32}
		}
		current = current.Children[c]
		if current.Length > len(word) {
			current.Length = len(word)
			current.Index = index
		}
	}
}

func (t *Trie) Find(word string) int {
	current := t
	for i, _ := range word {
		c := rune(word[len(word)-1-i])
		if _, ok := current.Children[c]; !ok {
			break
		}
		current = current.Children[c]
	}
	return current.Index
}