class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        histograms = [[0 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        for i in range(len(matrix[0])):
            histograms[0][i] = int(matrix[0][i])
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                histograms[i][j] = histograms[i-1][j] + 1 if matrix[i][j] == '1' else 0
        answer = 0
        for histogram in histograms:
            answer = max(answer, self.find(histogram))
        return answer
    
    def find(self, histogram):
        stack = []
        answer = 0
        for i in range(len(histogram)):
            while stack and histogram[i] <= histogram[stack[-1]]:
                height = histogram[stack.pop()]
                if not stack:
                    answer = max(answer, height * i)
                else:
                    answer = max(answer, height * (i - stack[-1] - 1))
            stack.append(i)
        while stack:
            height = histogram[stack.pop()]
            if not stack:
                answer = max(answer, height * len(histogram))
            else:
                answer = max(answer, height * (len(histogram) - stack[-1] - 1))
        return answer