func minAnagramLength(s string) int {
	lenSqrt := int(math.Sqrt(float64(len(s))))
	answer := math.MaxInt32
	for i := 1; i <= lenSqrt; i++ {
		if len(s)%i != 0 {
			continue
		}
		if possible(s, i) {
			answer = min(answer, i)
		}
		if possible(s, len(s)/i) {
			answer = min(answer, len(s)/i)
		}
	}
	return answer
}

func possible(s string, length int) bool {
	freq := make([]int, 26)
	size := 0
	for i := 0; i < length; i++ {
		freq[int(s[i])-int('a')] += 1
		if freq[int(s[i])-int('a')] == 1 {
			size += 1
		}
	}
	for i := length; i < len(s); i += length {
		newFreq := make([]int, 26)
		matched := 0
		for j := i; j < i+length; j++ {
			newFreq[int(s[j])-int('a')] += 1
			if newFreq[int(s[j])-int('a')] == freq[int(s[j])-int('a')] {
				matched += 1
			}
		}
		if matched != size {
			return false
		}
	}
	return true
}