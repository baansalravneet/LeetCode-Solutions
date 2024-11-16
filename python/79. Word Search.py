class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        visited = [[False for _ in range(len(board[0]))] for _ in range(len(board))]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, 0, word, visited):
                    return True
        return False

    def dfs(self, board, i, j, index, word, visited):
        if index == len(word):
            return True
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or visited[i][j] or board[i][j] != word[index]:
            return False
        visited[i][j] = True
        res = (
            self.dfs(board, i + 1, j, index + 1, word, visited)
                or self.dfs(board, i - 1, j, index + 1, word, visited)
                or self.dfs(board, i, j + 1, index + 1, word, visited)
                or self.dfs(board, i, j - 1, index + 1, word, visited)
        )
        visited[i][j] = False
        return res

