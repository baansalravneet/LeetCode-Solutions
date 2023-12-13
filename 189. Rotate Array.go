func rotate(nums []int, k int)  {
    for k > len(nums) {
        k = k - len(nums)
    }
    gcd := gcd(len(nums), k)
    start := 0
    for start < gcd {
        helper(&nums, k, start)
        start++
    }
}

func helper(nums *[]int, k, i int) {
    start := i
    n := len(*nums)
    i = (i-k+n)%n
    temp := (*nums)[i]
    for i != start {
        (*nums)[i] = (*nums)[(i-k+n)%n]
        i = (i-k+n)%n
    }
    (*nums)[start] = temp
}

func gcd(a, b int) int {
    if a > b {
        return gcd(b, a)
    }
    if a == 0 {
        return b
    }
    return gcd(b % a, a)
}
