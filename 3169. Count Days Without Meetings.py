class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort()
        i, end, answer = 0, 0, meetings[0][0]-1
        while i < len(meetings):
            end = meetings[i][1]
            while i < len(meetings) and meetings[i][0] <= end:
                end = max(end, meetings[i][1])
                i += 1
            if i < len(meetings):
                answer += meetings[i][0] - end - 1
        answer += days - end
        return answer