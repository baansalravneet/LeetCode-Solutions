func maxPointsInsideSquare(points [][]int, s string) int {
	pList := make([]*Point, len(points))
	for i := range(points) {
		pList[i] = &Point{x: points[i][0], y: points[i][1], tag: s[i]}
	}
	sort.Slice(pList, func(i, j int) bool {
		return pList[i].distance() < pList[j].distance()
	})
	set := make(map[byte]bool)
	answer := 0
	i := 0
	for i < len(pList) {
		distance := pList[i].distance()
		subset := make(map[byte]bool)
		for i < len(pList) && pList[i].distance() == distance {
			if _, ok := set[pList[i].tag]; ok {
				return answer
			}
			if _, ok := subset[pList[i].tag]; ok {
				return answer
			}
			subset[pList[i].tag] = true
			i += 1
		}
		answer = i
		for key := range subset {
			set[key] = true
		}	
	}
	return answer
}

type Point struct {
	x, y int
	tag byte
}

func (p *Point) distance() int {
	return max(abs(p.x), abs(p.y))
}

func abs(i int) int {
	if i < 0 { return -i }
	return i
}