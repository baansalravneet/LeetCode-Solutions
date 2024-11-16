func maxScoreWords(words []string, letters []byte, score []int) int {
	count := make([]int, 26, 26)
	for _, letter := range letters {
		count[letter-'a'] += 1
	}
	return find(words, count, score, 0)
}

func find(words []string, count, score []int, index int) int {
	if index >= len(words) { return 0 }
	answer := find(words, count, score, index+1)
	if canMake(words[index], count) {
		makeWord(words[index], count)
		wordScore := findScore(words[index], score)
		answer = max(answer, wordScore + find(words, count, score, index+1))
		unmakeWord(words[index], count)
	}
	return answer
}

func findScore(word string, score []int) int {
	answer := 0
	for _, letter := range word {
		answer += score[letter-'a']
	}
	return answer
}

func canMake(word string, count []int) bool {
	wordCount := make([]int, 26, 26)
	for _, letter := range word {
		wordCount[letter-'a'] += 1
	}
	for i := range 26 {
		if wordCount[i] > count[i] { return false }
	}
	return true
}

func makeWord(word string, count []int) {
	for _, letter := range word {
		count[letter - 'a'] -= 1
	}
}

func unmakeWord(word string, count []int) {
	for _, letter := range word {
		count[letter - 'a'] += 1
	}
}