func survivedRobotsHealths(positions []int, healths []int, directions string) []int {
	robots := make([]*robot, len(positions))
	for i := 0; i < len(positions); i++ {
		robots[i] = newRobot(i, positions[i], healths[i], directions[i])
	}
	sort.Slice(robots, func(i, j int) bool {
		return robots[i].position < robots[j].position
	})

	stack := make(stack, 0)

loop:
	for _, r := range robots {
		if len(stack) == 0 || r.direction == 'R' {
			stack.push(r)
			continue
		}
		for len(stack) > 0 && stack.peek().direction == 'R' {
			if stack.peek().health == r.health {
				stack.pop()
				continue loop
			}
			if stack.peek().health < r.health {
				stack.pop()
				r.health -= 1
			} else {
				stack.peek().health -= 1
				continue loop
			}
		}
		stack.push(r)
	}
	result := []*robot{}
	for len(stack) > 0 {
		result = append(result, stack.pop())
	}
	sort.Slice(result, func(i, j int) bool {
		return result[i].index < result[j].index
	})
	answer := []int{}
	for _, r := range result {
		answer = append(answer, r.health)
	}
	return answer
}

type robot struct {
	index     int
	position  int
	direction byte
	health    int
}

func newRobot(index, position, health int, direction byte) *robot {
	return &robot{index, position, direction, health}
}

type stack []*robot

func (s *stack) push(r *robot) {
	*s = append(*s, r)
}

func (s *stack) pop() *robot {
	if len(*s) == 0 {
		return nil
	}
	r := (*s)[len(*s)-1]
	*s = (*s)[:len(*s)-1]
	return r
}

func (s *stack) peek() *robot {
	if len(*s) == 0 {
		return nil
	}
	return (*s)[len(*s)-1]
}