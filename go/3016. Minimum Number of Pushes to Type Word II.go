func minimumPushes(word string) int {
    freq := make([]int, 26)
    for _, c := range word {
        freq[c-'a']++
    }
    sort.Slice(freq, func(i, j int) bool {
        return freq[i] > freq[j]
    })
    answer, count := 0, 0
    for _, v := range freq {
        answer += v * (count / 8 + 1)
        count++
    }
    return answer
}