class Solution:
    def maximumWeight(self, intervals: List[List[int]]) -> List[int]:
        intervals = sorted([(v[0], v[1], v[2], i) for i, v in enumerate(intervals)])
        def next_index(limit):
            left, right = 0, len(intervals)-1
            answer = len(intervals)
            while left <= right:
                mid = (left + right)//2
                if intervals[mid][0] > limit:
                    answer = mid
                    right = mid - 1
                else:
                    left = mid + 1
            return answer
        def smaller(a, b):
            a.sort()
            b.sort()
            for i in range(min(len(a), len(b))):
                if a[i] < b[i]:
                    return a
                elif b[i] < a[i]:
                    return b
            return a if len(a) < len(b) else b
        @cache
        def dp(idx, selected):
            if idx >= len(intervals) or selected == 4:
                return [0]
            no_take = dp(idx+1, selected)
            take = dp(next_index(intervals[idx][1]), selected+1)
            take = [intervals[idx][2] + take[0], *take[1:], intervals[idx][3]]
            if no_take[0] < take[0]:
                return take
            elif no_take[0] > take[0]:
                return no_take
            else:
                return [take[0], *smaller(take[1:], no_take[1:])]
        return sorted(dp(0, 0)[1:])