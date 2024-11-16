class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        currentSkill, wins, winner = skills[0], 0, 0
        for i in range(1, len(skills)):
            if skills[i] > currentSkill:
                wins, winner, currentSkill = 1, i, skills[i]
            else:
                wins += 1
            if wins >= k:
                break
        return winner

