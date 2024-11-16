class Solution:
    def trap(self, height: List[int]) -> int:
        answer = 0
        stack = []
        stack.append(0)
        for i in range(len(height)):
            while stack and height[i] >= height[stack[-1]]:
                h = height[stack.pop()]
                if stack:
                    answer += (i-stack[-1]-1)*(min(height[i], height[stack[-1]])-h)
            stack.append(i)
        return answer