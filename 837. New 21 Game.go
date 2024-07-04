func new21Game(n int, k int, maxPts int) float64 {
    if k == 0 {
        return 1
    }
	probs := make([]float64, k)
    probs[0] = 1
	p := 1/float64(maxPts)
	for i := 1; i < k; i++ {
		var soFar float64 = 0
		for j := max(1, i-maxPts); j < i; j++ {
			soFar += probs[j]
		}
        if (i <= maxPts) {
            soFar += 1
        }
		probs[i] += soFar * p
	}
	var answer float64 = 0
    for i := k-1; i >= max(0, k-maxPts); i-- {
		var val float64 = 0
        val = float64(max(0, i+maxPts-n))
		answer += probs[i] * val * p
	}
	return 1-answer
}