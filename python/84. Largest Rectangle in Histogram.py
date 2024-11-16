class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        answer = 0
        i = 0
        while i < len(heights):
            for not stack or heights[i] >= heights[stack[-1]]:
                height = heights[stack.pop()]
                if not stack:
                    answer = max(answer, i * height)
                else:
                    answer = max(answer, height * (i - stack[-1] - 1))
            stack.append(i)
            i += 1
        while not stack:
            height = heights[stack.pop()]
            if not stack:
                answer = max(answer, i * height)
            else:
                answer = max(answer, height * (i - stack[-1] - 1))
        return answer