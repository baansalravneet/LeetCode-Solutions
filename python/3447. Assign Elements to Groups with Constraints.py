class Solution:
    def assignElements(self, groups: List[int], elements: List[int]) -> List[int]:

        def divisors(num):
            for i in range(1, num+1):
                if i*i > num:
                    break
                if num % i == 0:
                    yield i
                    yield num/i

        answer = [float('inf')] * len(groups)
        element_index = {}
        for i, ele in enumerate(elements):
            element_index.setdefault(ele, i)
        for i in range(len(groups)):
            for div in divisors(groups[i]):
                if div not in element_index:
                    continue
                answer[i] = min(answer[i], element_index[div])
            if answer[i] == float('inf'):
                answer[i] = -1
        return answer
