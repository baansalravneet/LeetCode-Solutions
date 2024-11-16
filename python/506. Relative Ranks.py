class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        answer = []
        for i in range(len(score)):
            answer.append(i)
        answer.sort(key=lambda x: score[x], reverse=True)
        result = [""] * len(answer)
        for i in range(len(answer)):
            if i == 0:
                result[answer[0]] = "Gold Medal"
            elif i == 1:
                result[answer[1]] = "Silver Medal"
            elif i == 2:
                result[answer[2]] = "Bronze Medal"
            else:
                result[answer[i]] = str(i+1)
        return result
        