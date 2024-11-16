func kthSmallestPrimeFraction(arr []int, k int) []int {
	fractions := [][]int{}
	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			fractions = append(fractions, []int{arr[i], arr[j]})
		}
	}
	sort.Slice(fractions, func(i, j int) bool {
		return fractions[i][0]*fractions[j][1] < fractions[i][1]*fractions[j][0]
	})
	return fractions[k-1]
}