func groupAnagrams(strs []string) [][]string {
    if len(strs) == 0 {
        return [][]string{}
    }
    result := make(map[string][]string)
    for _, s := range strs {
        sortedString := getSorted(s)
        result[sortedString] = append(result[sortedString], s)
    }
    answer := [][]string{}
    index := 0
    for _, v := range result {
        answer = append(answer, []string{})
        answer[index] = append(answer[index], v...)
        index++
    }
    return answer
}

func getSorted(s string) string {
    w := strings.Split(s, "")
    sort.Strings(w)
    return strings.Join(w, "")
}
