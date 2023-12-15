func merge(intervals [][]int) [][]int {
    sort.SliceStable(intervals, func(i, j int) bool {
        return intervals[i][0] < intervals[j][0]
    })
    result := [][]int{}
    result = append(result, intervals[0])
    for i := 1; i < len(intervals); i++ {
        lastInterval := result[len(result)-1]
        thisInterval := intervals[i]
        if overlapping(lastInterval, thisInterval) {
            result[len(result)-1] = mergeIntervals(lastInterval, thisInterval)
        } else {
            result = append(result, thisInterval)
        }
    }
    return result
}

func mergeIntervals(a, b []int) []int {
    return []int{min(a[0], b[0]), max(a[1], b[1])}
}

func overlapping(a, b []int) bool {
    return a[1] - a[0] + 1 + b[1] - b[0] + 1 > max(a[1], b[1]) - min(a[0], b[0]) + 1
}
