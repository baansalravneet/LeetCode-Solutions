func maximumSafenessFactor(grid [][]int) int {
	n := len(grid)
	if n == 1 { return 0 }
	minDistances := findMin(grid)
	left, right := 0, n*n
	answer := math.MinInt32
	for left <= right {
		mid := (left + right) / 2
		if canDo(minDistances, mid) {
			answer = mid
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return answer
}
func canDo(minDistances [][]int, limit int) bool {
	n := len(minDistances)
	if minDistances[0][0] < limit { return false }
	if minDistances[n-1][n-1] < limit { return false }
	bfsQ := make([][]int, 0)
	visited := make([][]bool, n)
	for i := 0; i < n; i++ {
		visited[i] = make([]bool, n)
	}
	bfsQ = append(bfsQ, []int{0, 0})
	for len(bfsQ) > 0 {
		x, y := bfsQ[0][0], bfsQ[0][1]
		bfsQ = bfsQ[1:]
		if x == n-1 && y == n-1 { return true }
		if visited[x][y] { continue }
		visited[x][y] = true
		for _, d := range [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}} {
			nx, ny := x + d[0], y + d[1]
			if nx < 0 || nx >= n { continue }
			if ny < 0 || ny >= n { continue }
			if visited[nx][ny] { continue }
			if minDistances[nx][ny] < limit { continue }
			bfsQ = append(bfsQ, []int{nx, ny})
		}
	}
	return false
}

func findMin(grid [][]int) [][]int {
	n := len(grid)
	bfsQ := make([][]int, 0)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				bfsQ = append(bfsQ, []int{i, j})
			}
		}
	}
	visited := make([][]bool, n)
	minDistances := make([][]int, n)
	for i := 0; i < n; i++ {
		minDistances[i] = make([]int, n)
		visited[i] = make([]bool, n)
	}
	distance := 0
	for len(bfsQ) > 0 {
		size := len(bfsQ)
		for size > 0 {
			current := bfsQ[0]
			bfsQ = bfsQ[1:]
			size--
			x, y := current[0], current[1]
			if visited[x][y] { continue }
			visited[x][y] = true
			minDistances[x][y] = distance
			for _, d := range [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}} {
				nx, ny := x + d[0], y + d[1]
				if nx < 0 || nx >= n { continue }
				if ny < 0 || ny >= n { continue }
				if visited[nx][ny] { continue }
				bfsQ = append(bfsQ, []int{nx, ny})
			}
		}
		distance++
	}
	return minDistances
}