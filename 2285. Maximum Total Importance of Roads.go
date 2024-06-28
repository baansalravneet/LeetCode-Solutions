func maximumImportance(n int, roads [][]int) int64 {
    var answer, importance int64 = 0, 1
    degrees := make([]int, n)
    for _, road := range roads {
        degrees[road[0]]++
        degrees[road[1]]++
    }
    sort.Ints(degrees)
    for _, d := range degrees {
        answer += int64(d) * importance
        importance++
    }
    return answer
}

