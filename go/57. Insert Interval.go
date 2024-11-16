func insert(intervals [][]int, newInterval []int) [][]int {
    result := [][]int{}
    inserted := false
    for _, i := range intervals {
        if !inserted && newInterval[0] < i[0] {
            checkedAppend(&result, newInterval)
            inserted = true
        }
        checkedAppend(&result, i)
    }
    if !inserted {
        checkedAppend(&result, newInterval)
    }
    return result
}

func checkedAppend(result *[][]int, newInterval []int) {
    if len(*result) == 0 {
        *result = append(*result, newInterval)
    } else {
        lastInterval := (*result)[len(*result)-1]
        if overLapping(lastInterval, newInterval) {
            (*result)[len(*result)-1] = merge(lastInterval, newInterval)
        } else {
            *result = append(*result, newInterval)
        }
    }
}

func overLapping(a, b []int) bool {
    return a[1] - a[0] + 1 + b[1] - b[0] + 1 > max(a[1], b[1]) - min(a[0], b[0]) + 1
}

func merge(a, b []int) []int {
    return []int{min(a[0], b[0]), max(a[1], b[1])}
}
