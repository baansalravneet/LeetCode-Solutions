func minimumDifference(nums []int, k int) int {
    freq := make([]int, 32)
    answer := math.MaxInt32
    left := 0
    for right := 0; right < len(nums); right++ {
        add(freq, nums[right])
        curr := get(freq, right-left+1)
        answer = min(answer, abs(curr-k))
        for left <= right && curr < k {
            remove(freq, nums[left])
            left += 1
            curr = get(freq, right-left+1)
            answer = min(answer, abs(curr-k))
        }
    }
    return answer
}

func abs(i int) int {
    if i < 0 {
        return -i
    }
    return i
}

func add(freq []int, n int) {
    for i := 0; i < 32; i++ {
        if (n & (1 << i)) > 0 {
            freq[i] += 1
        }
    }
}

func remove(freq []int, n int) {
    for i := 0; i < 32; i++ {
        if (n & (1 << i)) > 0 {
            freq[i] -= 1
        }
    }
}

func get(freq []int, n int) int {
    answer := 0
    for i := 0; i < 32; i++ {
        if freq[i] == n {
            answer ^= (1 << i)
        }
    }
    return answer
}
