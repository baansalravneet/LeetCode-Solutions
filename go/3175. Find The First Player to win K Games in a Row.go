func findWinningPlayer(skills []int, k int) int {
    currentSkill := skills[0]
    wins := 0
    winner := 0
    for i := 1; i < len(skills); i++ {
        if skills[i] > currentSkill {
            wins = 1
            winner = i
            currentSkill = skills[i]
        } else {
            wins += 1
        }
        if wins >= k {
            break
        }
    }
    return winner
}
