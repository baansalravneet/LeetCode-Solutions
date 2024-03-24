func minOperations(k int) int {
    sqrt := int(math.Sqrt(float64(k)))
    return sqrt - 1 + (k-1)/sqrt
}

