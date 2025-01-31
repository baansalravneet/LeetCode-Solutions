class Solution:
    def countMentions(self, n: int, events: List[List[str]]) -> List[int]:

        def sort_order(a, b):
            if a[1] == b[1]:
                return -1 if b[0] == "MESSAGE" else 1
            return int(a[1]) - int(b[1])

        events.sort(key=cmp_to_key(sort_order))

        answer = [0] * n
        offline_time = [-60] * (n)
        count_all = 0

        for event in events:
            if event[0] == "MESSAGE":
                if event[2] == "ALL":
                    count_all += 1
                elif event[2] == "HERE":
                    for i in range(n):
                        if offline_time[i] <= int(event[1])-60:
                            answer[i] += 1
                else:
                    for i in event[2].split(" "):
                        answer[int(i[2:])] += 1
            else:
                offline_time[int(event[2])] = int(event[1])

        for i in range(n):
            answer[i] += count_all

        return answer