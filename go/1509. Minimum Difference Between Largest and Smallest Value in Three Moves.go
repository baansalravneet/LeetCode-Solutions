func minDifference(nums []int) int {
	topFour := getTopFour(nums)
	bottomFour := getBottomFour(nums)
	answer := math.MaxInt32
	for i := 0; i < 4; i++ {
		answer = min(answer, max(0, topFour[i]-bottomFour[i]))
	}
	return answer
}

func getTopFour(arr []int) []int {
	answer := make([]int, 4)
	for i := range answer {
		answer[i] = math.MinInt32
	}
	for _, v := range arr {
		if answer[3] < v {
			answer[0], answer[1], answer[2], answer[3] = answer[1], answer[2], answer[3], v
		} else if answer[2] < v {
			answer[0], answer[1], answer[2] = answer[1], answer[2], v
		} else if answer[1] < v {
			answer[0], answer[1] = answer[1], v
		} else if answer[0] < v {
			answer[0] = v
		}
	}
	return answer
}

func getBottomFour(arr []int) []int {
	answer := make([]int, 4)
	for i := range answer {
		answer[i] = math.MaxInt32
	}
	for _, v := range arr {
		if answer[0] > v {
			answer[0], answer[1], answer[2], answer[3] = v, answer[0], answer[1], answer[2]
		} else if answer[1] > v {
			answer[1], answer[2], answer[3] = v, answer[1], answer[2]
		} else if answer[2] > v {
			answer[2], answer[3] = v, answer[2]
		} else if answer[3] > v {
			answer[3] = v
		}
	}
	return answer
}