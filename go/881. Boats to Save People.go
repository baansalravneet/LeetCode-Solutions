func numRescueBoats(people []int, limit int) int {
	i, j, count := 0, len(people)-1, 0
	sort.Ints(people)
	for i <= j {
		if i != j && people[i]+people[j] <= limit {
			i += 1
		}
		j -= 1
		count += 1
	}
	return count
}