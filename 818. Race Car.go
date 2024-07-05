func racecar(target int) int {
	visited := make(map[[2]int]bool)
	bfsQ := bfsQ{}
	bfsQ.push(state{0, 1, 0})
	for bfsQ.len() > 0 {
		current := bfsQ.pop()

		if current.position == target {
			return current.count
		}

		if !visited[[2]int{current.position+current.speed, 2*current.speed}] {
			bfsQ.push(state{current.position+current.speed, 2*current.speed, current.count+1})
			visited[[2]int{current.position+current.speed, 2*current.speed}] = true
		}

		if current.speed > 0 {
			if !visited[[2]int{current.position, -1}] {
				bfsQ.push(state{current.position, -1, current.count+1})
				visited[[2]int{current.position, -1}] = true
			}
		}

		if current.speed < 0 {
			if !visited[[2]int{current.position, 1}] {
				bfsQ.push(state{current.position, 1, current.count+1})
				visited[[2]int{current.position, 1}] = true
			}
		}
		
	}
	return -1
}

type state struct {
	position int
	speed    int
	count    int
}

type bfsQ []state

func (b *bfsQ) push(s state) {
	(*b) = append(*b, s)
}

func (b *bfsQ) pop() state {
	val := (*b)[0]
	(*b) = (*b)[1:]
	return val
}

func (b *bfsQ) len() int {
	return len(*b)
}