class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        revision1 = version1.split('.')
        revision2 = version2.split('.')
        i, j = 0, 0
        while i < len(revision1) or j < len(revision2):
            num1 = 0 if i >= len(revision1) else int(revision1[i])
            num2 = 0 if j >= len(revision2) else int(revision2[j])
            if num1 < num2:
                return -1
            elif num1 > num2:
                return 1
            i += 1
            j += 1
        return 0