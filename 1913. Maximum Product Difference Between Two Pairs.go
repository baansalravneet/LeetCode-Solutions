func maxProductDifference(nums []int) int {
    a, b, c, d := -1, -1, 100000, 100000
    for _, v := range nums {
        if a < v {
            a, b = v, a
        } else if b < v {
            b = v
        }
        if c > v {
            c, d = v, c
        } else if d > v  {
            d = v
        }
    }
    return a*b - c*d
}
