func maxNumEdgesToRemove(n int, edges [][]int) int {
	alice := newUnionFind(n)
	bob := newUnionFind(n)
	count := 0

	for _, edge := range edges {
		if edge[0] == 3 {
			count += alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2])
		}
	}

	for _, edge := range edges {
		if edge[0] == 1 {
			count += alice.union(edge[1], edge[2])
		}
		if edge[0] == 2 {
			count += bob.union(edge[1], edge[2])
		}
	}

	if alice.canTraverse() && bob.canTraverse() {
		return len(edges) - count
	}
	return -1

}

type unionFind struct {
    parents []int
	components int
}

func newUnionFind(n int) *unionFind {
	arr := make([]int, n+1)
	for i := 0; i <= n; i++ {
		arr[i] = i
	}
	return &unionFind {arr, n}
}

func (u *unionFind) union(a, b int) int {
	parentA, parentB := u.find(a), u.find(b)
	if parentA != parentB {
		if parentA < parentB {
			u.parents[parentB] = parentA
		} else {
			u.parents[parentA] = parentB
		}
		u.components -= 1
		return 1
	}
	return 0
}

func (u *unionFind) find(a int) int {
	if u.parents[a] == a {
		return a
	}
	u.parents[a] = u.find(u.parents[a])
	return u.parents[a]
}

func (u *unionFind) canTraverse() bool {
	return u.components == 1
}