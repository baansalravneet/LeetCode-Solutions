func minimumCost(n int, edges [][]int, query [][]int) []int {
	uf := newUnionFind(n)
	for _, edge := range edges {
		uf.union(edge[0], edge[1], edge[2])
	}
	answer := make([]int, len(query))
	for i, q := range query {
		x, y := q[0], q[1]
		if x == y {
			answer[i] = 0
		} else if uf.find(x) != uf.find(y) {
			answer[i] = -1
		} else {
			answer[i] = uf.findWeight(x)
			if answer[i] == (1<<31)-1 {
				answer[i] = 0
			}
		}
	}
	return answer
}

type UnionFind struct {
	parent     []int
	bitwiseAnd []int
}

func newUnionFind(n int) *UnionFind {
	uf := &UnionFind{
		parent: make([]int, n),
		bitwiseAnd: make([]int, n),
	}
	for i := 0; i < n; i++ {
		uf.parent[i] = i
		uf.bitwiseAnd[i] = (1 << 31) - 1
	}
	return uf
}

func (uf *UnionFind) find(x int) int {
	if uf.parent[x] != x {
		uf.parent[x] = uf.find(uf.parent[x])
	}
	return uf.parent[x]
}

func (uf *UnionFind) findWeight(x int) int {
	return uf.bitwiseAnd[uf.find(x)]
}

func (uf *UnionFind) union(x, y, weight int) {
	rootX := uf.find(x)
	rootY := uf.find(y)
	if x < y {
		uf.parent[rootY] = rootX
		uf.bitwiseAnd[rootX] &= uf.bitwiseAnd[rootY] & weight
	} else {
		uf.parent[rootX] = rootY
		uf.bitwiseAnd[rootY] &= uf.bitwiseAnd[rootX] & weight
	}
}
