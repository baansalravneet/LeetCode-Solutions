func maxProfitAssignment(difficulty []int, profit []int, worker []int) int {
    jobs := make([]job, len(profit))
    for i := range profit {
        jobs[i] = newJob(difficulty[i], profit[i])
    }
    sort.Slice(jobs, func(i, j int) bool {
        return jobs[i].difficulty < jobs[j].difficulty
    })
    maxProfit := make([]int, len(profit))
    maxProfit[0] = jobs[0].profit
    for i := 1; i < len(jobs); i++ {
        maxProfit[i] = max(jobs[i].profit, maxProfit[i-1])
    }
    answer := 0
    for _, ability := range worker {
        possibleDifficultyIndex := findDifficultyIndex(jobs, ability)
        if possibleDifficultyIndex == -1 { continue }
        answer += maxProfit[possibleDifficultyIndex]
    }
    return answer
}

func findDifficultyIndex(jobs []job, ability int) int {
    left, right, answer := 0, len(jobs)-1, -1
    for left <= right {
        mid := (left + right) / 2
        if jobs[mid].difficulty <= ability {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return answer
}

type job struct {
    difficulty int
    profit int
}

func newJob(difficulty, profit int) job {
    return job { difficulty: difficulty, profit: profit }
}
