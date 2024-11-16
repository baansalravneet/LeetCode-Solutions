class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        fractions = []
        for i in range(len(arr)):
            for j in range(i+1, len(arr)):
                fractions.append((arr[i], arr[j]))
        fractions.sort(key=cmp_to_key(compare))
        return fractions[k-1]

def compare(x,y):
    return x[0]*y[1] - x[1]*y[0]