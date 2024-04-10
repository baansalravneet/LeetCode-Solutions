func deckRevealedIncreasing(deck []int) []int {
	sort.Ints(deck)
	q := []int{}
	for i := len(deck) - 1; i >= 0; i-- {
		if len(q) > 0 {
			q = append([]int{q[len(q)-1]}, q[:len(q)-1]...)
		}
		q = append([]int{deck[i]}, q...)
	}
	return q
}