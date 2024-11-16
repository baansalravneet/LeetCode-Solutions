class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        colour_count = {}
        ball_colour = {}
        answer = []
        for q in queries:
            ball, colour = q[0], q[1]
            if ball not in ball_colour:
                if colour not in colour_count:
                    colour_count[colour] = 0
                colour_count[colour] += 1
            else:
                previous_colour = ball_colour[ball]
                if previous_colour != colour:
                    if colour_count[previous_colour] == 1:
                        colour_count.pop(previous_colour)
                    else:
                        colour_count[previous_colour] -= 1
                    if colour not in colour_count:
                        colour_count[colour] = 0
                    colour_count[colour] += 1
            ball_colour[ball] = colour
            answer.append(len(colour_count))
        return answer

                
