class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        count, i, j = 0, 0, len(people)-1
        people.sort()
        while i <= j:
            if i != j and people[i]+people[j] <= limit:
                i += 1
                j -= 1
            else:
                j -= 1
            count += 1
        return count
