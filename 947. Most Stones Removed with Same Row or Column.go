func removeStones(stones [][]int) int {
    n := len(stones)
    uf := newUf(n)
    for i := 0; i < n; i++ {
        for j := i+1; j < n; j++ {
            if stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1] {
                uf.union(i, j)
            }
        }
    }
    return n - uf.count
}

type unionFind struct {
    parent []int
    count int
}

func newUf(n int) *unionFind {
    parent := make([]int, n)
    for i := 0; i < n; i++ {
        parent[i] = i
    }
    return &unionFind{parent, n}
}

func (uf *unionFind) union(i, j int) {
    parentI, parentJ := uf.find(i), uf.find(j)
    if parentI == parentJ { return }
    if parentI < parentJ {
        uf.parent[parentJ] = parentI
    } else {
        uf.parent[parentI] = parentJ
    }
    uf.count--
}

func (uf *unionFind) find(i int) int {
    if uf.parent[i] == i { return i }
    uf.parent[i] = uf.find(uf.parent[i])
    return uf.parent[i]
}

