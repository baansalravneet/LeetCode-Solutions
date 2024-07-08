func maximumPoints(enemyEnergies []int, currentEnergy int) int64 {
    var answer int64
	j := len(enemyEnergies)-1
	
	sort.Ints(enemyEnergies)

	if enemyEnergies[0] > currentEnergy { return 0 }

	for j >= 0 && currentEnergy >= enemyEnergies[0] {
		answer += int64(currentEnergy / enemyEnergies[0])
		currentEnergy %= enemyEnergies[0]
		currentEnergy += enemyEnergies[j]
		j--
	}
	
	return answer
}