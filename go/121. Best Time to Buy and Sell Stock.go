func maxProfit(prices []int) int {
    maxPrice := prices[len(prices)-1]
    answer := 0
    for i := len(prices)-1; i >= 0; i-- {
        answer = max(answer, maxPrice - prices[i])
        maxPrice = max(maxPrice, prices[i])
    }
    return answer
}
